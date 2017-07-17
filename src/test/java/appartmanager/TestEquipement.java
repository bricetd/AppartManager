package appartmanager;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mby.appartmanager.dao.EquipementService;
import com.mby.appartmanager.dao.impl.DocumentServiceImpl;
import com.mby.appartmanager.dao.impl.EquipementServiceImpl;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Equipement;

public class TestEquipement {

	private EquipementService equipementService;
	private Date date_achat = new Date();
	private String nom = "equipement001";
	private short valeur = (short)10;
	private long equipementID;
	private long documentID;

	@BeforeClass
	public void init() {
		EquipementServiceImpl.getInstance().setDocumentService(DocumentServiceImpl.getInstance());
		equipementService = EquipementServiceImpl.getInstance();
	}

	//@Test(dependsOnMethods="delete")
	@Test
	public void testCreate() {
		Equipement equipement = new Equipement();
		equipement.setDate_achat(date_achat);
		equipement.setNom(nom);
		equipement.setValeur(valeur);
		equipementService.saveObject(equipement);
		Assert.assertNotNull(equipement.getId());
		equipementID = equipement.getId();
	}
	
	@Test(dependsOnMethods="testCreate")
	public void testGet() {
		Equipement equipement = equipementService.getObjectById(equipementID);
		Assert.assertEquals(equipement.getNom(), nom);
		Assert.assertEquals(equipement.getValeur(),valeur);
		// TODO Manage date format in DB and for tests.
//		Assert.assertEquals(equipement.getDate_achat(),date_achat);
	}
	
	@Test(dependsOnMethods="testGet")
	public void testUpdate() throws Exception {
		Equipement equipement = equipementService.getObjectById(equipementID);
		
		Date date_achat = new Date();
		String nom = "equipement001";
		short valeur = (short)10;

		equipement.setDate_achat(date_achat);
		equipement.setNom(nom);
		equipement.setValeur(valeur);
		
		equipementService.updateObject(equipementID,equipement);
		equipement = equipementService.getObjectById(equipementID);
		
		Assert.assertEquals(equipement.getNom(), nom);
		Assert.assertEquals(equipement.getValeur(),valeur);
		// TODO Manage date format in DB and for tests.
//		Assert.assertEquals(equipement.getDate_achat(),date_achat);
	}
	
	@Test(dependsOnMethods="testUpdate")
	public void testAddDocument() throws Exception {
		Document doc = new Document();
		doc.setNom("new docs");
		doc.setFichier("mon fichier 001");
		DocumentServiceImpl.getInstance().saveObject(doc);
		Assert.assertNotNull(doc.getId());
		documentID = doc.getId();
		equipementService.addDocument(equipementID, doc.getId());
		Equipement equipement = equipementService.getObjectById(equipementID);
		Assert.assertTrue(equipement.getDocuments().size() == 1);
		Assert.assertEquals(equipement.getDocuments().get(0).getId(), doc.getId());
	}
	
	@Test(dependsOnMethods="testAddDocument")
	public void testDelete() {
		//Delete created equipements
		Equipement equipement = equipementService.getObjectById(equipementID);
		Assert.assertNotNull(equipement);
		equipementService.deleteObject(equipementID);
		equipement = equipementService.getObjectById(equipementID);
		Assert.assertNull(equipement);
		
		//Delete create documents
		Document doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNotNull(doc);
		DocumentServiceImpl.getInstance().deleteObject(documentID);
		doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNull(doc);
	}
	
//	@AfterClass()
//	public void clean(){
//		equipementService.delete(equipementID);
//	}
}
