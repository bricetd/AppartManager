package appartmanager;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mby.appartmanager.dao.IncidentService;
import com.mby.appartmanager.dao.impl.DocumentServiceImpl;
import com.mby.appartmanager.dao.impl.IncidentServiceImpl;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Incident;

public class TestIncident {

	private IncidentService incidentService;
	private Date date = new Date();
	private Date date_fin = new Date();
	private String libelle = "non paiement du loyer";
	private String description = "non paiement du loyer";
	private String justification = "non paiement du loyer";
	private long incidentID;
	private long documentID;

	@BeforeClass
	public void init() {
		IncidentServiceImpl.getInstance().setDocumentService(DocumentServiceImpl.getInstance());
		incidentService = IncidentServiceImpl.getInstance();
	}

	//@Test(dependsOnMethods="delete")
	@Test
	public void testCreate() {
		Incident incident = new Incident();
		incident.setDate(date);
		incident.setLibelle(libelle);
		incident.setDate_fin(date_fin);
		incident.setJustification(justification);
		incident.setDescription(description);
		incidentService.saveObject(incident);
		Assert.assertNotNull(incident.getId());
		incidentID = incident.getId();
	}
	
	@Test(dependsOnMethods="testCreate")
	public void testGet() {
		Incident incident = incidentService.getObjectById(incidentID);
		Assert.assertEquals(incident.getLibelle(), libelle);
		Assert.assertEquals(incident.getDescription(), description);
		Assert.assertEquals(incident.getJustification(), justification);
		// TODO Manage date format in DB and for tests.
//		Assert.assertEquals(incident.getDate(),date);
//		Assert.assertEquals(incident.getDate_fin(), date_fin);
	}
	
	@Test(dependsOnMethods="testGet")
	public void testUpdate() throws Exception {
		Incident incident = incidentService.getObjectById(incidentID);
	
		Date date = new Date();
		Date date_fin = new Date();
		String libelle = "non paiement du loyer 2";
		String description = "non paiement du loyer 2 pour toujours";
		String justification = "nouvelle raison";
		
		incident.setDate(date);
		incident.setLibelle(libelle);
		incident.setDate_fin(date_fin);
		incident.setJustification(justification);
		incident.setDescription(description);
		
		incidentService.updateObject(incidentID,incident);
		incident = incidentService.getObjectById(incidentID);
		
		Assert.assertEquals(incident.getLibelle(), libelle);
		Assert.assertEquals(incident.getDescription(), description);
		Assert.assertEquals(incident.getJustification(), justification);
		// TODO Manage date format in DB and for tests.
//		Assert.assertEquals(incident.getDate(),date);
//		Assert.assertEquals(incident.getDate_fin(), date_fin);
	}
	
	@Test(dependsOnMethods="testUpdate")
	public void testAddDocument() throws Exception {
		Document doc = new Document();
		doc.setNom("new docs");
		doc.setFichier("mon fichier 001");
		DocumentServiceImpl.getInstance().saveObject(doc);
		Assert.assertNotNull(doc.getId());
		documentID = doc.getId();
		incidentService.addDocument(incidentID, doc.getId());
		Incident incident = incidentService.getObjectById(incidentID);
		Assert.assertTrue(incident.getDocuments().size() == 1);
		for (Document d : incident.getDocuments()) {
			Assert.assertEquals(d.getId(), doc.getId());
		}
	}
	
	@Test(dependsOnMethods="testAddDocument")
	public void testDelete() {
		//Delete created incidents
		Incident incident = incidentService.getObjectById(incidentID);
		Assert.assertNotNull(incident);
		incidentService.deleteObject(incidentID);
		incident = incidentService.getObjectById(incidentID);
		Assert.assertNull(incident);
		
		//Delete create documents
		Document doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNotNull(doc);
		DocumentServiceImpl.getInstance().deleteObject(documentID);
		doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNull(doc);
	}
	
//	@AfterClass()
//	public void clean(){
//		incidentService.delete(incidentID);
//	}
}
