package appartmanager;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mby.appartmanager.dao.DispositifFiscalService;
import com.mby.appartmanager.dao.impl.DispositifFiscalServiceImpl;
import com.mby.appartmanager.models.DispositifFiscal;

public class TestDispositifFiscal {

	private DispositifFiscalService dispFiscService;
	private String nom = "loi pinel";
	private String conditions = "6 9 ou 12 ans de locations obligatoire";
	private String articles_loi = "loi pinel, loi 125655";
	private short duree = (short)6;
	private long dispFiscId;

	@BeforeClass
	public void init() {
		dispFiscService = DispositifFiscalServiceImpl.getInstance();
	}

	//@Test(dependsOnMethods="deleteDispositifFiscal")
	@Test
	public void testCreateDispositifFiscal() {
		DispositifFiscal dispFisc = new DispositifFiscal();
		dispFisc.setDuree(duree);
		dispFisc.setArticles_loi(articles_loi);
		dispFisc.setConditions(conditions);
		dispFisc.setNom(nom);
		dispFiscService.saveObject(dispFisc);
		Assert.assertNotNull(dispFisc.getId());
		dispFiscId = dispFisc.getId();
	}
	
	@Test(dependsOnMethods="testCreateDispositifFiscal")
	public void testGetDispositifFiscal() {
		DispositifFiscal dispFisc = dispFiscService.getObjectById(dispFiscId);
		Assert.assertEquals(dispFisc.getNom(),nom);
		Assert.assertEquals(dispFisc.getDuree(),duree);
		Assert.assertEquals(dispFisc.getArticles_loi(),articles_loi);
		Assert.assertEquals(dispFisc.getConditions(),conditions);
	}
	
	@Test(dependsOnMethods="testGetDispositifFiscal")
	public void testUpdateDispositifFiscal() throws Exception {
		DispositifFiscal dispFisc = dispFiscService.getObjectById(dispFiscId);
		
		String nom = "Loi Cellier";
		String conditions = "je ne sais pas";
		String articles_loi = "loi cellier, loi 5454543";
		short duree = (short)25;

		dispFisc.setArticles_loi(articles_loi);
		dispFisc.setConditions(conditions);
		dispFisc.setNom(nom);
		dispFisc.setDuree(duree);
	
		dispFiscService.updateObject(dispFiscId,dispFisc);
		dispFisc = dispFiscService.getObjectById(dispFiscId);
		Assert.assertEquals(dispFisc.getNom(),nom);
		Assert.assertEquals(dispFisc.getDuree(),duree);
		Assert.assertEquals(dispFisc.getArticles_loi(),articles_loi);
		Assert.assertEquals(dispFisc.getConditions(),conditions);
	}
	
	@Test(dependsOnMethods="testUpdateDispositifFiscal")
	public void testDeleteDispositifFiscal() {
		DispositifFiscal dispFisc = dispFiscService.getObjectById(dispFiscId);
		Assert.assertNotNull(dispFisc);
		dispFiscService.deleteObject(dispFiscId);
		dispFisc = dispFiscService.getObjectById(dispFiscId);
		Assert.assertNull(dispFisc);
	}
}
