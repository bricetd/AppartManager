package appartmanager;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mby.appartmanager.dao.LocataireService;
import com.mby.appartmanager.dao.impl.CoordonneesServiceImpl;
import com.mby.appartmanager.dao.impl.DocumentServiceImpl;
import com.mby.appartmanager.dao.impl.IncidentServiceImpl;
import com.mby.appartmanager.dao.impl.LocataireServiceImpl;
import com.mby.appartmanager.dao.impl.PaiementServiceImpl;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Incident;
import com.mby.appartmanager.models.Locataire;
import com.mby.appartmanager.models.Paiement;

public class TestLocataire {

	private LocataireService locataireService;
	private String nom = "locataire 001";
	private String prenom = "prenom locataire 001";
	private Date date_naissance = new Date();
	private Locataire.StatusMarital statusMarital = Locataire.StatusMarital.CELIBATAIRE;
	private short revenusMensuel = (short) 10;
	private String employeur = "Societe generale";
	private Short anciennete = (short) 20;
	private String cautionnaire = "cautionnaire du locataire 001";

	private long locataireID;
	private long paiementID;
	private long incidentID;
	private long documentID;

	@BeforeClass
	public void init() {
		LocataireServiceImpl.getInstance().setDocumentService(DocumentServiceImpl.getInstance());
		LocataireServiceImpl.getInstance().setCoordonneesService(CoordonneesServiceImpl.getInstance());
		LocataireServiceImpl.getInstance().setIncidentService(IncidentServiceImpl.getInstance());
		LocataireServiceImpl.getInstance().setPaiementService(PaiementServiceImpl.getInstance());

		locataireService = LocataireServiceImpl.getInstance();
	}

	// @Test(dependsOnMethods="delete")
	@Test
	public void testCreate() {
		Locataire locataire = new Locataire();
		locataire.setAnciennete(anciennete);
		locataire.setCautionnaire(cautionnaire);
		locataire.setDate_naissance(date_naissance);
		locataire.setEmployeur(employeur);
		locataire.setNom(nom);
		locataire.setPrenom(prenom);
		locataire.setDate_naissance(date_naissance);
		locataire.setStatusMarital(statusMarital);
		locataire.setRevenusMensuel(revenusMensuel);

		locataireService.saveObject(locataire);
		Assert.assertNotNull(locataire.getId());
		locataireID = locataire.getId();
	}

	@Test(dependsOnMethods = "testCreate")
	public void testGet() {
		Locataire locataire = locataireService.getObjectById(locataireID);
		Assert.assertEquals(locataire.getAnciennete(), anciennete);
		Assert.assertEquals(locataire.getCautionnaire(), cautionnaire);
		Assert.assertEquals(locataire.getEmployeur(), employeur);
		Assert.assertEquals(locataire.getNom(), nom);
		Assert.assertEquals(locataire.getPrenom(), prenom);
		Assert.assertEquals(locataire.getStatusMarital(), statusMarital);
		Assert.assertEquals(locataire.getEmployeur(), employeur);
		Assert.assertEquals(locataire.getRevenusMensuel(), revenusMensuel);

		// TODO Manage date format in DB and for tests.
		// Assert.assertEquals(locataire.Date_naissance(),date_naissance);
	}

	@Test(dependsOnMethods = "testGet")
	public void testUpdate() throws Exception {
		Locataire locataire = locataireService.getObjectById(locataireID);

		String nom = "locataire 001";
		String prenom = "prenom locataire 001";
		Date date_naissance = new Date();
		Locataire.StatusMarital statusMarital = Locataire.StatusMarital.CELIBATAIRE;
		short revenusMensuel = (short) 10;
		String employeur = "Societe generale";
		Short anciennete = (short) 20;
		String cautionnaire = "cautionnaire du locataire 001";

		locataire.setAnciennete(anciennete);
		locataire.setCautionnaire(cautionnaire);
		locataire.setDate_naissance(date_naissance);
		locataire.setEmployeur(employeur);
		locataire.setNom(nom);
		locataire.setPrenom(prenom);
		locataire.setDate_naissance(date_naissance);
		locataire.setStatusMarital(statusMarital);
		locataire.setRevenusMensuel(revenusMensuel);

		locataireService.updateObject(locataireID, locataire);
		locataire = locataireService.getObjectById(locataireID);
		Assert.assertEquals(locataire.getAnciennete(), anciennete);
		Assert.assertEquals(locataire.getCautionnaire(), cautionnaire);
		Assert.assertEquals(locataire.getEmployeur(), employeur);
		Assert.assertEquals(locataire.getNom(), nom);
		Assert.assertEquals(locataire.getPrenom(), prenom);
		Assert.assertEquals(locataire.getStatusMarital(), statusMarital);
		Assert.assertEquals(locataire.getEmployeur(), employeur);
		Assert.assertEquals(locataire.getRevenusMensuel(), revenusMensuel);
		// TODO
		// Assert.assertEquals(locataire.Date_naissance(),date_naissance);
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testAddDocument() throws Exception {
		Document doc = new Document();
		doc.setNom("new docs");
		doc.setFichier("mon fichier 001");
		DocumentServiceImpl.getInstance().saveObject(doc);
		Assert.assertNotNull(doc.getId());
		documentID = doc.getId();
		locataireService.addDocument(locataireID, doc.getId());
		Locataire locataire = locataireService.getObjectById(locataireID);
		Assert.assertTrue(locataire.getDocuments().size() == 1);
		for (Document d : locataire.getDocuments()) {
			Assert.assertEquals(d.getId(), doc.getId());
		}
	}

	@Test(dependsOnMethods = "testAddDocument")
	public void testAddPaiement() throws Exception {
		Paiement paiement = new Paiement();
		paiement.setCategorie(Paiement.Categorie.CAUTION);
		paiement.setCommentaire("paiement de la caution");
		paiement.setDate(new Date());
		paiement.setMontant((short) 9999);
		paiement.setModepaiement(Paiement.ModePaiement.AUTRE);
		PaiementServiceImpl.getInstance().saveObject(paiement);
		Assert.assertNotNull(paiement.getId());
		paiementID = paiement.getId();
		Locataire locataire = locataireService.getObjectById(locataireID);
		locataire.addPaiement(paiement);
		locataireService.updateObject(locataireID, locataire);
		locataire = locataireService.getObjectById(locataireID);
		for (Paiement p : locataire.getPaiements()) {
			Assert.assertEquals(p.getId(), paiement.getId());
			Assert.assertEquals(p.getMontant(), paiement.getMontant());
			Assert.assertEquals(p.getModepaiement(), paiement.getModepaiement());
		}
	}

	@Test(dependsOnMethods = "testAddPaiement")
	public void testAddIncident() throws Exception {
		Incident incident = new Incident();
		incident.setDate(new Date());
		incident.setDate_fin(new Date());
		incident.setDescription("Le nouvel incident du locataire");
		incident.setJustification("mon n'incident ce n'est pas de ma faute");
		incident.setLibelle("Paiment en retard en octobre 2019");
		IncidentServiceImpl.getInstance().saveObject(incident);
		Assert.assertNotNull(incident.getId());
		incidentID = incident.getId();
		Locataire locataire = locataireService.getObjectById(locataireID);
		locataire.addIncident(incident);
		locataireService.updateObject(locataireID, locataire);
		locataire = locataireService.getObjectById(locataireID);
		for (Incident i : locataire.getIncidents()) {
			Assert.assertEquals(i.getId(), incident.getId());
			Assert.assertEquals(i.getDescription(), incident.getDescription());
			Assert.assertEquals(i.getJustification(), incident.getJustification());
		}
	}

	@Test(dependsOnMethods = "testAddIncident")
	public void testDelete() {
		// Delete created locataires
		Locataire locataire = locataireService.getObjectById(locataireID);
		Assert.assertNotNull(locataire);
		locataireService.deleteObject(locataireID);
		locataire = locataireService.getObjectById(locataireID);
		Assert.assertNull(locataire);

		// Delete created paiement
		Paiement paiement = PaiementServiceImpl.getInstance().getObjectById(paiementID);
		Assert.assertNotNull(paiement);
		PaiementServiceImpl.getInstance().deleteObject(paiementID);
		paiement = PaiementServiceImpl.getInstance().getObjectById(paiementID);
		Assert.assertNull(paiement);

		// Delete created incident
		Incident incident = IncidentServiceImpl.getInstance().getObjectById(incidentID);
		Assert.assertNotNull(incident);
		IncidentServiceImpl.getInstance().deleteObject(incidentID);
		incident = IncidentServiceImpl.getInstance().getObjectById(incidentID);
		Assert.assertNull(incident);

		// Delete create documents
		Document doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNotNull(doc);
		DocumentServiceImpl.getInstance().deleteObject(documentID);
		doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNull(doc);
	}

	// @AfterClass()
	// public void clean(){
	// locataireService.delete(locataireID);
	// }
}
