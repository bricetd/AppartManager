package appartmanager;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mby.appartmanager.dao.CoordonneesService;
import com.mby.appartmanager.dao.impl.CoordonneesServiceImpl;
import com.mby.appartmanager.models.Coordonnees;

public class TestCoordonnees {

	private String adresse = "mon adresse";
	private String fixe = "0134507051";
	private String email = "raoul@google.fr";
	private String fax = "0134507052";
	private String mobile = "0134507052";
	private String autre = "0134507054";
	private String commentaire = "Voici un grand commentaire";
	private short code_postal = (short)95370;
	private CoordonneesService coordService;
	private long coordId;

	@BeforeClass
	public void init() {
		coordService = CoordonneesServiceImpl.getInstance();
	}

	//@Test(dependsOnMethods="deleteCoordonnees")
	@Test
	public void testCreateCoordonnees() {
		Coordonnees coord = new Coordonnees();
		coord.setAdresse(adresse);
		coord.setAutre(autre);
		coord.setCode_postal(code_postal);
		coord.setCommentaire(commentaire);
		coord.setEmail(email);
		coord.setFax(fax);
		coord.setFixe(fixe);
		coord.setMobile(mobile);
		coordService.saveObject(coord);
		Assert.assertNotNull(coord.getId());
		coordId = coord.getId();
	}
	
	@Test(dependsOnMethods="testCreateCoordonnees")
	public void testGetCoordonnees() {
		Coordonnees coord = coordService.getObjectById(coordId);
		Assert.assertEquals(coord.getAdresse(),adresse);
		Assert.assertEquals(coord.getAutre(),autre);
		Assert.assertEquals(coord.getCode_postal(),code_postal);
		Assert.assertEquals(coord.getCommentaire(),commentaire);
		Assert.assertEquals(coord.getEmail(),email);
		Assert.assertEquals(coord.getFax(),fax);
		Assert.assertEquals(coord.getFixe(),fixe);
		Assert.assertEquals(coord.getMobile(),mobile);
		
	}
	
	@Test(dependsOnMethods="testGetCoordonnees")
	public void testUpdateCoordonnees() throws Exception {
		Coordonnees coord = coordService.getObjectById(coordId);
		
		String adresse = "mon adresse";
		String fixe = "0134507051";
		String email = "raoul@google.fr";
		String fax = "0134507052";
		String mobile = "0134507052";
		String autre = "0134507054";
		String commentaire = "Voici un grand commentaire";
		short code_postal = (short)95370;
		
		coord.setAdresse(adresse);
		coord.setAutre(autre);
		coord.setCode_postal(code_postal);
		coord.setCommentaire(commentaire);
		coord.setEmail(email);
		coord.setFax(fax);
		coord.setFixe(fixe);
		coord.setMobile(mobile);
		
		coordService.updateObject(coordId,coord);
		coord = coordService.getObjectById(coordId);
		Assert.assertEquals(coord.getAdresse(),adresse);
		Assert.assertEquals(coord.getAutre(),autre);
		Assert.assertEquals(coord.getCode_postal(),code_postal);
		Assert.assertEquals(coord.getCommentaire(),commentaire);
		Assert.assertEquals(coord.getEmail(),email);
		Assert.assertEquals(coord.getFax(),fax);
		Assert.assertEquals(coord.getFixe(),fixe);
		Assert.assertEquals(coord.getMobile(),mobile);
	}
	
	@Test(dependsOnMethods="testUpdateCoordonnees")
	public void testDeleteCoordonnees() {
		Coordonnees coord = coordService.getObjectById(coordId);
		Assert.assertNotNull(coord);
		coordService.deleteObject(coordId);
		coord = coordService.getObjectById(coordId);
		Assert.assertNull(coord);
	}
	
//	@AfterClass()
//	public void clean(){
//		coordService.deleteCoordonnees(coordId);
//	}
}
