package appartmanager;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mby.appartmanager.dao.GestionnaireService;
import com.mby.appartmanager.dao.impl.ContratGestionServiceImpl;
import com.mby.appartmanager.dao.impl.CoordonneesServiceImpl;
import com.mby.appartmanager.dao.impl.GestionnaireServiceImpl;
import com.mby.appartmanager.models.ContratGestion;
import com.mby.appartmanager.models.Coordonnees;
import com.mby.appartmanager.models.Gestionnaire;

public class TestGestionnaire {

	private GestionnaireService gestionnaireService;
	private String nom = "gestionnaire 001";
	private String prenom = "prenom gestionnaire 001";
	private String raison_sociale = "Societe generale";

	private long gestionnaireID;
	private long contratGestionID;
	private long coordonneesID;

	@BeforeClass
	public void init() {
		GestionnaireServiceImpl.getInstance().setCoordonneesService(CoordonneesServiceImpl.getInstance());
		GestionnaireServiceImpl.getInstance().setContratGestionService(ContratGestionServiceImpl.getInstance());

		gestionnaireService = GestionnaireServiceImpl.getInstance();
	}

	// @Test(dependsOnMethods="delete")
	@Test
	public void testCreate() {
		Gestionnaire gestionnaire = new Gestionnaire();
		gestionnaire.setNom(nom);
		gestionnaire.setPrenom(prenom);
		gestionnaire.setRaison_sociale(raison_sociale);

		gestionnaireService.saveObject(gestionnaire);
		Assert.assertNotNull(gestionnaire.getId());
		gestionnaireID = gestionnaire.getId();
	}

	@Test(dependsOnMethods = "testCreate")
	public void testGet() {
		Gestionnaire gestionnaire = gestionnaireService.getObjectById(gestionnaireID);
		Assert.assertEquals(gestionnaire.getNom(), nom);
		Assert.assertEquals(gestionnaire.getPrenom(), prenom);
		Assert.assertEquals(gestionnaire.getRaison_sociale(), raison_sociale);
	}

	@Test(dependsOnMethods = "testGet")
	public void testUpdate() throws Exception {
		Gestionnaire gestionnaire = gestionnaireService.getObjectById(gestionnaireID);

		String nom = "gestionnaire 001";
		String prenom = "prenom gestionnaire 001";
		String raison_sociale = "Societe generale";

		gestionnaire.setNom(nom);
		gestionnaire.setPrenom(prenom);
		gestionnaire.setRaison_sociale(raison_sociale);

		gestionnaireService.updateObject(gestionnaireID, gestionnaire);
		gestionnaire = gestionnaireService.getObjectById(gestionnaireID);
		Assert.assertEquals(gestionnaire.getNom(), nom);
		Assert.assertEquals(gestionnaire.getPrenom(), prenom);
		Assert.assertEquals(gestionnaire.getRaison_sociale(), raison_sociale);
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testAddContratGestion() throws Exception {
		ContratGestion contratGestion = new ContratGestion();
		contratGestion.setDate_debut(new Date());
		contratGestion.setDate_fin(new Date());
		contratGestion.setDuree((short) 20);
		contratGestion.setTariff((short) 300);
		ContratGestionServiceImpl.getInstance().saveObject(contratGestion);
		Assert.assertNotNull(contratGestion.getId());
		contratGestionID = contratGestion.getId();
		gestionnaireService.addContratGestion(gestionnaireID, contratGestionID);
		Gestionnaire gestionnaire = gestionnaireService.getObjectById(gestionnaireID);
		for (ContratGestion c : gestionnaire.getContratGestions()) {
			Assert.assertEquals(c.getId(), contratGestionID);
			Assert.assertEquals(c.getDuree(), contratGestion.getDuree());
			Assert.assertEquals(c.getTariff(), contratGestion.getTariff());
		}
	}

	@Test(dependsOnMethods = "testAddContratGestion")
	public void testSetCoordonnees() throws Exception {
		Coordonnees coordonnees = new Coordonnees();
		coordonnees.setAdresse("Mon adresse");
		coordonnees.setAutre("Autre phone");
		coordonnees.setCode_postal((short) 95370);
		coordonnees.setCommentaire("Un commentaire");
		coordonnees.setEmail("bricetd@gmail.com");
		CoordonneesServiceImpl.getInstance().saveObject(coordonnees);
		Assert.assertNotNull(coordonnees.getId());
		coordonneesID = coordonnees.getId();
		gestionnaireService.setCoordonnees(gestionnaireID, coordonneesID);
		Gestionnaire gestionnaire = gestionnaireService.getObjectById(gestionnaireID);
		Coordonnees c = gestionnaire.getCoordonnees();
		Assert.assertEquals(c.getId(), coordonneesID);
		Assert.assertEquals(c.getAdresse(), coordonnees.getAdresse());
		Assert.assertEquals(c.getAutre(), coordonnees.getAutre());
		Assert.assertEquals(c.getCode_postal(), coordonnees.getCode_postal());
		Assert.assertEquals(c.getEmail(), coordonnees.getEmail());
		Assert.assertEquals(c.getCommentaire(), coordonnees.getCommentaire());
	}

	@Test(dependsOnMethods = "testSetCoordonnees")
	public void testDelete() {
		// Delete created gestionnaires
		Gestionnaire gestionnaire = gestionnaireService.getObjectById(gestionnaireID);
		Assert.assertNotNull(gestionnaire);
		gestionnaireService.deleteObject(gestionnaireID);
		gestionnaire = gestionnaireService.getObjectById(gestionnaireID);
		Assert.assertNull(gestionnaire);

		// Delete created contratGestion
		Coordonnees coordonnees = CoordonneesServiceImpl.getInstance().getObjectById(coordonneesID);
		Assert.assertNotNull(coordonneesID);
		CoordonneesServiceImpl.getInstance().deleteObject(coordonneesID);
		coordonnees = CoordonneesServiceImpl.getInstance().getObjectById(coordonneesID);
		Assert.assertNull(coordonnees);

		// Delete created contratGestion
		ContratGestion contratGestion = ContratGestionServiceImpl.getInstance().getObjectById(contratGestionID);
		Assert.assertNotNull(contratGestion);
		ContratGestionServiceImpl.getInstance().deleteObject(contratGestionID);
		contratGestion = ContratGestionServiceImpl.getInstance().getObjectById(contratGestionID);
		Assert.assertNull(contratGestion);
	}
	// @AfterClass()
	// public void clean(){
	// gestionnaireService.delete(gestionnaireID);
	// }
}
