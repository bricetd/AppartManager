package appartmanager;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mby.appartmanager.dao.ChargesService;
import com.mby.appartmanager.dao.impl.ChargesServiceImpl;
import com.mby.appartmanager.dao.impl.DocumentServiceImpl;
import com.mby.appartmanager.dao.impl.PaiementServiceImpl;
import com.mby.appartmanager.models.Charges;
import com.mby.appartmanager.models.Charges.Frequence;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Paiement;

public class TestCharges {

	private ChargesService chargesService;
	private String nom = "charges 001";
	private short montant = (short)100;
	private Frequence frequence = Frequence.MENSUEL;
	private Date date_echeance = new Date();

	private long chargesID;
	private long paiementID;
	private long documentID;

	@BeforeClass
	public void init() {
		ChargesServiceImpl.getInstance().setDocumentService(DocumentServiceImpl.getInstance());
		ChargesServiceImpl.getInstance().setPaiementService(PaiementServiceImpl.getInstance());

		chargesService = ChargesServiceImpl.getInstance();
	}

	// @Test(dependsOnMethods="delete")
	@Test
	public void testCreate() {
		Charges charges = new Charges();
		charges.setDate_echeance(date_echeance);
		charges.setFrequence(frequence);
		charges.setMontant(montant);
		charges.setNom(nom);
		chargesService.saveObject(charges);
		Assert.assertNotNull(charges.getId());
		chargesID = charges.getId();
	}

	@Test(dependsOnMethods = "testCreate")
	public void testGet() {
		Charges charges = chargesService.getObjectById(chargesID);
		Assert.assertEquals(charges.getMontant(), montant);
		Assert.assertEquals(charges.getFrequence(), frequence);
		Assert.assertEquals(charges.getNom(), nom);
		// TODO Manage date format in DB and for tests.
		// Assert.assertEquals(charges.getDate_echeance(),date_echeance);
	}

	@Test(dependsOnMethods = "testGet")
	public void testUpdate() throws Exception {
		Charges charges = chargesService.getObjectById(chargesID);

		String nom = "charges 002";
		short montant = (short)199;
		Frequence frequence = Frequence.UNIQUE;
		Date date_echeance = new Date();
		
		charges.setDate_echeance(date_echeance);
		charges.setFrequence(frequence);
		charges.setMontant(montant);
		charges.setNom(nom);


		chargesService.updateObject(chargesID, charges);
		charges = chargesService.getObjectById(chargesID);
		Assert.assertEquals(charges.getMontant(), montant);
		Assert.assertEquals(charges.getFrequence(), frequence);
		Assert.assertEquals(charges.getNom(), nom);
		// TODO Manage date format in DB and for tests.
		// Assert.assertEquals(charges.getDate_echeance(),date_echeance);
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testAddDocument() throws Exception {
		Document doc = new Document();
		doc.setNom("new docs");
		doc.setFichier("mon fichier 001");
		DocumentServiceImpl.getInstance().saveObject(doc);
		Assert.assertNotNull(doc.getId());
		documentID = doc.getId();
		chargesService.addDocument(chargesID, documentID);
		Charges charges = chargesService.getObjectById(chargesID);
		Assert.assertTrue(charges.getDocuments().size() == 1);
		for (Document d : charges.getDocuments()) {
			Assert.assertEquals(d.getId(), documentID);
		}
	}

	@Test(dependsOnMethods = "testAddDocument")
	public void testAddPaiement() throws Exception {
		Paiement paiement = new Paiement();
		paiement.setCategorie(Paiement.Categorie.CAUTION);
		paiement.setCommentaire("paiement de la caution");
		paiement.setDate(new Date());
		paiement.setMontant((short) 9999);
		paiement.setModepaiement(Paiement.ModePaiement.AUTRE);
		PaiementServiceImpl.getInstance().saveObject(paiement);
		Assert.assertNotNull(paiement.getId());
		paiementID = paiement.getId();
		Charges charges = chargesService.addPaiement(chargesID, paiementID);
		charges = chargesService.getObjectById(chargesID);
		for (Paiement p : charges.getPaiements()) {
			Assert.assertEquals(p.getId(), paiement.getId());
			Assert.assertEquals(p.getMontant(), paiement.getMontant());
			Assert.assertEquals(p.getModepaiement(), paiement.getModepaiement());
		}
	}

	@Test(dependsOnMethods = "testAddPaiement")
	public void testDelete() {
		// Delete created chargess
		Charges charges = chargesService.getObjectById(chargesID);
		Assert.assertNotNull(charges);
		chargesService.deleteObject(chargesID);
		charges = chargesService.getObjectById(chargesID);
		Assert.assertNull(charges);

		// Delete created paiement
		Paiement paiement = PaiementServiceImpl.getInstance().getObjectById(paiementID);
		Assert.assertNotNull(paiement);
		PaiementServiceImpl.getInstance().deleteObject(paiementID);
		paiement = PaiementServiceImpl.getInstance().getObjectById(paiementID);
		Assert.assertNull(paiement);

		// Delete create documents
		Document doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNotNull(doc);
		DocumentServiceImpl.getInstance().deleteObject(documentID);
		doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNull(doc);
	}

	// @AfterClass()
	// public void clean(){
	// chargesService.delete(chargesID);
	// }
}
