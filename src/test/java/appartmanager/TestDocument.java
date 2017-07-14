package appartmanager;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mby.appartmanager.dao.DocumentService;
import com.mby.appartmanager.dao.impl.DocumentServiceImpl;
import com.mby.appartmanager.models.Document;

public class TestDocument {

	private String nomDoc = "mon document";
	private String nomFichier = "fichier1";
	private DocumentService docService;
	private long docId;

	@BeforeClass
	public void init() {
		docService = DocumentServiceImpl.getInstance();
	}

	//@Test(dependsOnMethods="deleteDocument")
	@Test
	public void testCreateDocument() {
		Document doc = new Document();
		doc.setNom(nomDoc);
		doc.setFichier(nomFichier);
		docService.saveObject(doc);
		Assert.assertNotNull(doc.getId());
		docId = doc.getId();
	}
	
	@Test(dependsOnMethods="testCreateDocument")
	public void testGetDocument() {
		Document doc = docService.getObjectById(docId);
		Assert.assertEquals(doc.getNom(),nomDoc);
		Assert.assertEquals(doc.getFichier(),nomFichier);
		Assert.assertNotNull(doc.getDate_ajout());
		Assert.assertNotNull(doc.getDate_modification());
		
	}
	
	@Test(dependsOnMethods="testGetDocument")
	public void testUpdateDocument() throws Exception {
		Document doc = docService.getObjectById(docId);
		Date oldDateAjout = doc.getDate_ajout();
		Date oldDateModification = doc.getDate_modification();
		String newNomDoc = "mon document2";
		String newNomFichier = "fichier2";
		doc.setFichier(newNomFichier);
		doc.setNom(newNomDoc);
		docService.updateObject(docId,doc);
		doc = docService.getObjectById(docId);
		Assert.assertEquals(doc.getNom(),newNomDoc);
		Assert.assertEquals(doc.getFichier(),newNomFichier);
		Assert.assertEquals(doc.getDate_ajout(),oldDateAjout);
		Assert.assertNotEquals(doc.getDate_modification(),oldDateModification);
	}
	
	@Test(dependsOnMethods="testUpdateDocument")
	public void testDeleteDocument() {
		Document doc = docService.getObjectById(docId);
		Assert.assertNotNull(doc);
		docService.deleteObject(docId);
		doc = docService.getObjectById(docId);
		Assert.assertNull(doc);
	}
	
//	@AfterClass()
//	public void clean(){
//		docService.deleteDocument(docId);
//	}
}
