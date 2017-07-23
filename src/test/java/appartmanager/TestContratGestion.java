package appartmanager;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mby.appartmanager.dao.ContratGestionService;
import com.mby.appartmanager.dao.impl.DocumentServiceImpl;
import com.mby.appartmanager.dao.impl.OptionsServiceImpl;
import com.mby.appartmanager.dao.impl.ContratGestionServiceImpl;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Options;
import com.mby.appartmanager.models.ContratGestion;

public class TestContratGestion {

	private ContratGestionService contratGestionService;
	private short duree = (short)10;
	private short tariff = (short)175;
	private Date date_debut = new Date();
	private Date date_fin= new Date();
	
	private long contratGestionID;
	private long documentID;
	private long optionsID;

	@BeforeClass
	public void init() {
		ContratGestionServiceImpl.getInstance().setDocumentService(DocumentServiceImpl.getInstance());
		ContratGestionServiceImpl.getInstance().setOptionsService(OptionsServiceImpl.getInstance());
		contratGestionService = ContratGestionServiceImpl.getInstance();
	}

	// @Test(dependsOnMethods="delete")
	@Test
	public void testCreate() {
		ContratGestion contratGestion = new ContratGestion();
		contratGestion.setDate_debut(date_debut);
		contratGestion.setDate_fin(date_fin);
		contratGestion.setDuree(duree);
		contratGestion.setTariff(tariff);
		contratGestionService.saveObject(contratGestion);
		Assert.assertNotNull(contratGestion.getId());
		contratGestionID = contratGestion.getId();
	}

	@Test(dependsOnMethods = "testCreate")
	public void testGet() {
		ContratGestion contratGestion = contratGestionService.getObjectById(contratGestionID);
		Assert.assertEquals(contratGestion.getDuree(), duree);
		Assert.assertEquals(contratGestion.getTariff(), tariff);
		//TODO
//		Assert.assertEquals(contratGestion.getDate_debut(), date_debut);
//		Assert.assertEquals(contratGestion.getDate_fin(), date_fin);
	}

	@Test(dependsOnMethods = "testGet")
	public void testUpdate() throws Exception {
		ContratGestion contratGestion = contratGestionService.getObjectById(contratGestionID);

		short duree = (short)100;
		short tariff = (short)17885;
		Date date_debut= new Date();
		Date date_fin= new Date();

		
		contratGestion.setDate_debut(date_debut);
		contratGestion.setDate_fin(date_fin);
		contratGestion.setDuree(duree);
		contratGestion.setTariff(tariff);

		contratGestionService.updateObject(contratGestionID, contratGestion);
		contratGestion = contratGestionService.getObjectById(contratGestionID);
		
		Assert.assertEquals(contratGestion.getDuree(), duree);
		Assert.assertEquals(contratGestion.getTariff(), tariff);
		//TODO
//		Assert.assertEquals(contratGestion.getDate_debut(), date_debut);
//		Assert.assertEquals(contratGestion.getDate_fin(), date_fin);
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testAddDocument() throws Exception {
		Document doc = new Document();
		doc.setNom("new docs");
		doc.setFichier("mon fichier 001");
		DocumentServiceImpl.getInstance().saveObject(doc);
		Assert.assertNotNull(doc.getId());
		documentID = doc.getId();
		contratGestionService.addDocument(contratGestionID, doc.getId());
		ContratGestion contratGestion = contratGestionService.getObjectById(contratGestionID);
		Assert.assertTrue(contratGestion.getDocuments().size() == 1);
		for (Document d : contratGestion.getDocuments()) {
			Assert.assertEquals(d.getId(), doc.getId());
		}
	}

	@Test(dependsOnMethods = "testAddDocument")
	public void testAddOptions() throws Exception {
		Options options = new Options();
		options.setAssurance_loyer_impaye(true);
		options.setEtablissement_bail(false);
		options.setGerance(true);
		options.setRecherche_locataire(true);
		OptionsServiceImpl.getInstance().saveObject(options);
		Assert.assertNotNull(options.getId());
		optionsID = options.getId();
		contratGestionService.setOptions(contratGestionID, options.getId());
		ContratGestion contratGestion = contratGestionService.getObjectById(contratGestionID);
		Assert.assertNotNull(contratGestion.getOptions());
		Assert.assertEquals(contratGestion.getOptions().isAssurance_loyer_impaye(), options.isAssurance_loyer_impaye());
		Assert.assertEquals(contratGestion.getOptions().isEtablissement_bail(), options.isEtablissement_bail());
		Assert.assertEquals(contratGestion.getOptions().isGerance(), options.isGerance());
		Assert.assertEquals(contratGestion.getOptions().isRecherche_locataire(), options.isRecherche_locataire());
	}

	@Test(dependsOnMethods = "testAddOptions")
	public void testDelete() {
		// Delete created contratGestions
		ContratGestion contratGestion = contratGestionService.getObjectById(contratGestionID);
		Assert.assertNotNull(contratGestion);
		contratGestionService.deleteObject(contratGestionID);
		contratGestion = contratGestionService.getObjectById(contratGestionID);
		Assert.assertNull(contratGestion);

		// Delete created optionss
		Options options = OptionsServiceImpl.getInstance().getObjectById(optionsID);
		Assert.assertNotNull(options);
		OptionsServiceImpl.getInstance().deleteObject(optionsID);
		options = OptionsServiceImpl.getInstance().getObjectById(optionsID);
		Assert.assertNull(options);

		// Delete created documents
		Document doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNotNull(doc);
		DocumentServiceImpl.getInstance().deleteObject(documentID);
		doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNull(doc);
	}

	// @AfterClass()
	// public void clean(){
	// contratGestionService.delete(contratGestionID);
	// }
}
