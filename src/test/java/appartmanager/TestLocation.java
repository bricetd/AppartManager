package appartmanager;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mby.appartmanager.dao.LocationService;
import com.mby.appartmanager.dao.impl.DocumentServiceImpl;
import com.mby.appartmanager.dao.impl.LocataireServiceImpl;
import com.mby.appartmanager.dao.impl.LocationServiceImpl;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Locataire;
import com.mby.appartmanager.models.Locataire.StatusMarital;
import com.mby.appartmanager.models.Location;

public class TestLocation {

	private LocationService locationService;
	private Date date_debut = new Date();
	private Date date_fin = new Date();
	private boolean isCollocation = false;
	private boolean isMeuble = true;
	
	private long locationID;
	private long documentID;
	private long locataireID;

	@BeforeClass
	public void init() {
		LocationServiceImpl.getInstance().setDocumentService(DocumentServiceImpl.getInstance());
		LocationServiceImpl.getInstance().setLocataireService(LocataireServiceImpl.getInstance());
		locationService = LocationServiceImpl.getInstance();
	}

	// @Test(dependsOnMethods="delete")
	@Test
	public void testCreate() {
		Location location = new Location();
		location.setDate_debut(date_debut);
		location.setDate_fin(date_fin);
		location.setCollocation(isCollocation);
		location.setMeuble(isMeuble);
		locationService.saveObject(location);
		Assert.assertNotNull(location.getId());
		locationID = location.getId();
	}

	@Test(dependsOnMethods = "testCreate")
	public void testGet() {
		Location location = locationService.getObjectById(locationID);
		Assert.assertEquals(location.isCollocation(), isCollocation);
		Assert.assertEquals(location.isMeuble(), isMeuble);
		//TODO
//		Assert.assertEquals(location.getDate_debut(), date_debut);
//		Assert.assertEquals(location.getDate_fin(), date_fin);
	}

	@Test(dependsOnMethods = "testGet")
	public void testUpdate() throws Exception {
		Location location = locationService.getObjectById(locationID);

		Date date_debut = new Date();
		Date date_fin = new Date();
		boolean isCollocation = true;
		boolean isMeuble = false;

		location.setDate_debut(date_debut);
		location.setDate_fin(date_fin);
		location.setCollocation(isCollocation);
		location.setMeuble(isMeuble);

		locationService.updateObject(locationID, location);
		location = locationService.getObjectById(locationID);

		Assert.assertEquals(location.isCollocation(), isCollocation);
		Assert.assertEquals(location.isMeuble(), isMeuble);
		//TODO
//		Assert.assertEquals(location.getDate_debut(), date_debut);
//		Assert.assertEquals(location.getDate_fin(), date_fin);
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testAddDocument() throws Exception {
		Document doc = new Document();
		doc.setNom("new docs");
		doc.setFichier("mon fichier 001");
		DocumentServiceImpl.getInstance().saveObject(doc);
		Assert.assertNotNull(doc.getId());
		documentID = doc.getId();
		locationService.addDocument(locationID, doc.getId());
		Location location = locationService.getObjectById(locationID);
		Assert.assertTrue(location.getDocuments().size() == 1);
		for (Document d : location.getDocuments()) {
			Assert.assertEquals(d.getId(), doc.getId());
		}
	}

	@Test(dependsOnMethods = "testAddDocument")
	public void testAddLocataire() throws Exception {
		Locataire locataire = new Locataire();
		locataire.setNom("mon locataire");
		locataire.setAnciennete((short)10);
		locataire.setCautionnaire("Mon cautionnaire");
		locataire.setEmployeur("Alcatel-Lucent");
		locataire.setPrenom("Jeannot");
		locataire.setDate_naissance(new Date());
		locataire.setStatusMarital(StatusMarital.CELIBATAIRE);
		LocataireServiceImpl.getInstance().saveObject(locataire);
		Assert.assertNotNull(locataire.getId());
		locataireID = locataire.getId();
		locationService.addLocataire(locationID, locataireID);
		Location location = locationService.getObjectById(locationID);
		Assert.assertTrue(location.getLocataires().size() == 1);
		for (Locataire e : location.getLocataires()) {
			Assert.assertEquals(e.getId(), locataireID);
			Assert.assertEquals(e.getNom(), locataire.getNom());
			Assert.assertEquals(e.getAnciennete(), locataire.getAnciennete());
			Assert.assertEquals(e.getCautionnaire(), locataire.getCautionnaire());
			Assert.assertEquals(e.getEmployeur(), locataire.getEmployeur());
			Assert.assertEquals(e.getPrenom(), locataire.getPrenom());
			Assert.assertEquals(e.getStatusMarital(), locataire.getStatusMarital());
		}
	}

	@Test(dependsOnMethods = "testAddLocataire")
	public void testDelete() {
		// Delete created locations
		Location location = locationService.getObjectById(locationID);
		Assert.assertNotNull(location);
		locationService.deleteObject(locationID);
		location = locationService.getObjectById(locationID);
		Assert.assertNull(location);

		// Delete created locataires
		Locataire locataire = LocataireServiceImpl.getInstance().getObjectById(locataireID);
		Assert.assertNotNull(locataire);
		LocataireServiceImpl.getInstance().deleteObject(locataireID);
		locataire = LocataireServiceImpl.getInstance().getObjectById(locataireID);
		Assert.assertNull(locataire);

		// Delete created documents
		Document doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNotNull(doc);
		DocumentServiceImpl.getInstance().deleteObject(documentID);
		doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNull(doc);
	}

	// @AfterClass()
	// public void clean(){
	// locationService.delete(locationID);
	// }
}
