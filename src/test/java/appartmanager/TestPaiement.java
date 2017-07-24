package appartmanager;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mby.appartmanager.dao.PaiementService;
import com.mby.appartmanager.dao.impl.DocumentServiceImpl;
import com.mby.appartmanager.dao.impl.PaiementServiceImpl;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Paiement;
import com.mby.appartmanager.models.Paiement.Categorie;
import com.mby.appartmanager.models.Paiement.ModePaiement;

public class TestPaiement {

	private PaiementService paiementService;
	private Date date = new Date();
	private Paiement.Categorie categorie = Categorie.CAUTION;
	private Paiement.ModePaiement modePaiement = ModePaiement.CARTEBLEUE;	
	private String commentaire = "le paiement est bien effectue";
	private short montant = (short)10;
	private long paiementID;
	private long documentID;

	@BeforeClass
	public void init() {
		PaiementServiceImpl.getInstance().setDocumentService(DocumentServiceImpl.getInstance());
		paiementService = PaiementServiceImpl.getInstance();
	}

	//@Test(dependsOnMethods="delete")
	@Test
	public void testCreate() {
		Paiement paiement = new Paiement();
		paiement.setDate(date);
		paiement.setCategorie(categorie);
		paiement.setCommentaire(commentaire);
		paiement.setModepaiement(modePaiement);
		paiement.setMontant(montant);
		paiementService.saveObject(paiement);
		Assert.assertNotNull(paiement.getId());
		paiementID = paiement.getId();
	}
	
	@Test(dependsOnMethods="testCreate")
	public void testGet() {
		Paiement paiement = paiementService.getObjectById(paiementID);
		Assert.assertEquals(paiement.getCategorie(), categorie);
		Assert.assertEquals(paiement.getMontant(), montant);
		Assert.assertEquals(paiement.getModepaiement(), modePaiement);
		Assert.assertEquals(paiement.getCommentaire(), commentaire);
		// TODO Manage date format in DB and for tests.
//		Assert.assertEquals(paiement.getDate(),date);
	}
	
	@Test(dependsOnMethods="testGet")
	public void testUpdate() throws Exception {
		Paiement paiement = paiementService.getObjectById(paiementID);
		
		Date date = new Date();
		Paiement.Categorie categorie = Categorie.CAUTION;
		Paiement.ModePaiement modePaiement = ModePaiement.CARTEBLEUE;	
		String commentaire = "le paiement est bien effectue";
		short montant = (short)10;
		
		paiement.setDate(date);
		paiement.setCategorie(categorie);
		paiement.setCommentaire(commentaire);
		paiement.setModepaiement(modePaiement);
		paiement.setMontant(montant);
		
		paiementService.updateObject(paiementID,paiement);
		paiement = paiementService.getObjectById(paiementID);
		
		Assert.assertEquals(paiement.getCategorie(), categorie);
		Assert.assertEquals(paiement.getMontant(), montant);
		Assert.assertEquals(paiement.getModepaiement(), modePaiement);
		Assert.assertEquals(paiement.getCommentaire(), commentaire);
		// TODO Manage date format in DB and for tests.
//		Assert.assertEquals(paiement.getDate(),date);
	}
	
	@Test(dependsOnMethods="testUpdate")
	public void testAddDocument() throws Exception {
		Document doc = new Document();
		doc.setNom("new docs");
		doc.setFichier("mon fichier 001");
		DocumentServiceImpl.getInstance().saveObject(doc);
		Assert.assertNotNull(doc.getId());
		documentID = doc.getId();
		paiementService.addDocument(paiementID, documentID);
		Paiement paiement = paiementService.getObjectById(paiementID);
		Assert.assertTrue(paiement.getDocuments().size() == 1);
		for (Document d : paiement.getDocuments()) {
			Assert.assertEquals(d.getId(), documentID);
		}
	}
	
	@Test(dependsOnMethods="testAddDocument")
	public void testDelete() {
		//Delete created paiements
		Paiement paiement = paiementService.getObjectById(paiementID);
		Assert.assertNotNull(paiement);
		paiementService.deleteObject(paiementID);
		paiement = paiementService.getObjectById(paiementID);
		Assert.assertNull(paiement);
		
		//Delete create documents
		Document doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNotNull(doc);
		DocumentServiceImpl.getInstance().deleteObject(documentID);
		doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNull(doc);
	}
	
//	@AfterClass()
//	public void clean(){
//		paiementService.delete(paiementID);
//	}
}
