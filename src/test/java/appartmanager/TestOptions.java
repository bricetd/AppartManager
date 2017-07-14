package appartmanager;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mby.appartmanager.dao.OptionsService;
import com.mby.appartmanager.dao.impl.OptionsServiceImpl;
import com.mby.appartmanager.models.Options;

public class TestOptions {

	private OptionsService optionsService;
	private long optId;

	@BeforeClass
	public void init() {
		optionsService = OptionsServiceImpl.getInstance();
	}

	//@Test(dependsOnMethods="deleteOptions")
	@Test
	public void testCreateOptions() {
		Options opt = new Options();
		opt.setAssurance_loyer_impaye(false);
		opt.setEtablissement_bail(false);
		opt.setGerance(false);
		opt.setRecherche_locataire(false);
		optionsService.saveObject(opt);
		Assert.assertNotNull(opt.getId());
		optId = opt.getId();
	}
	
	@Test(dependsOnMethods="testCreateOptions")
	public void testGetOptions() {
		Options opt = optionsService.getObjectById(optId);
		Assert.assertFalse(opt.isAssurance_loyer_impaye());
		Assert.assertFalse(opt.isEtablissement_bail());
		Assert.assertFalse(opt.isGerance());
		Assert.assertFalse(opt.isRecherche_locataire());
		
	}
	
	@Test(dependsOnMethods="testGetOptions")
	public void testUpdateOptions() throws Exception {
		Options opt = optionsService.getObjectById(optId);
		opt.setAssurance_loyer_impaye(true);
		opt.setEtablissement_bail(true);
		opt.setGerance(true);
		opt.setRecherche_locataire(true);
		optionsService.updateObject(optId,opt);
		opt = optionsService.getObjectById(optId);
		Assert.assertTrue(opt.isAssurance_loyer_impaye());
		Assert.assertTrue(opt.isEtablissement_bail());
		Assert.assertTrue(opt.isGerance());
		Assert.assertTrue(opt.isRecherche_locataire());	
}
	
	@Test(dependsOnMethods="testUpdateOptions")
	public void testDeleteOptions() {
		Options opt = optionsService.getObjectById(optId);
		Assert.assertNotNull(opt);
		optionsService.deleteObject(optId);
		opt = optionsService.getObjectById(optId);
		Assert.assertNull(opt);
	}
	
//	@AfterClass()
//	public void clean(){
//		optionsService.deleteOptions(docId);
//	}
}
