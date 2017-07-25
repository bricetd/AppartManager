package appartmanager;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mby.appartmanager.dao.AppartementService;
import com.mby.appartmanager.dao.impl.AppartementServiceImpl;
import com.mby.appartmanager.dao.impl.ChargesServiceImpl;
import com.mby.appartmanager.dao.impl.CoordonneesServiceImpl;
import com.mby.appartmanager.dao.impl.DocumentServiceImpl;
import com.mby.appartmanager.dao.impl.GestionnaireServiceImpl;
import com.mby.appartmanager.dao.impl.LocationServiceImpl;
import com.mby.appartmanager.dao.impl.PieceServiceImpl;
import com.mby.appartmanager.dao.impl.TransactionServiceImpl;
import com.mby.appartmanager.models.Appartement;
import com.mby.appartmanager.models.Charges;
import com.mby.appartmanager.models.Charges.Frequence;
import com.mby.appartmanager.models.Coordonnees;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Gestionnaire;
import com.mby.appartmanager.models.Location;
import com.mby.appartmanager.models.Piece;
import com.mby.appartmanager.models.Transaction;
import com.mby.appartmanager.models.Transaction.Type;

public class TestAppartement {

	private AppartementService appartementService;

	private String nom = "appartement 001";
	private short etage = (short) 1;
	private short surface = (short) 10;
	private boolean hasParking = true;
	private boolean hasCave = false;

	private long appartementID;
	private long transactionID;
	private long locationID;
	private long documentID;
	private long coordonneesID;
	private long pieceID;
	private long chargesID;
	private long gestionnairesID;

	@BeforeClass
	public void init() {
		AppartementServiceImpl.getInstance().setDocumentService(DocumentServiceImpl.getInstance());
		AppartementServiceImpl.getInstance().setCoordonneesService(CoordonneesServiceImpl.getInstance());
		AppartementServiceImpl.getInstance().setTransactionService(TransactionServiceImpl.getInstance());
		AppartementServiceImpl.getInstance().setChargesService(ChargesServiceImpl.getInstance());
		AppartementServiceImpl.getInstance().setGestionnaireService(GestionnaireServiceImpl.getInstance());
		AppartementServiceImpl.getInstance().setLocationService(LocationServiceImpl.getInstance());
		AppartementServiceImpl.getInstance().setPieceService(PieceServiceImpl.getInstance());

		appartementService = AppartementServiceImpl.getInstance();
	}

	// @Test(dependsOnMethods="delete")
	@Test
	public void testCreate() {
		Appartement appartement = new Appartement();
		appartement.setNom(nom);
		appartement.setSurface(surface);
		appartement.setEtage(etage);
		appartement.setHasCave(hasCave);
		appartement.setHasParking(hasParking);

		appartementService.saveObject(appartement);
		Assert.assertNotNull(appartement.getId());
		appartementID = appartement.getId();
	}

	@Test(dependsOnMethods = "testCreate")
	public void testGet() {
		Appartement appartement = appartementService.getObjectById(appartementID);
		Assert.assertEquals(appartement.getNom(), nom);
		Assert.assertEquals(appartement.getEtage(), etage);
		Assert.assertEquals(appartement.getSurface(), surface);
		Assert.assertEquals(appartement.isHasCave(), hasCave);
		Assert.assertEquals(appartement.isHasParking(), hasParking);
	}

	@Test(dependsOnMethods = "testGet")
	public void testUpdate() throws Exception {
		Appartement appartement = appartementService.getObjectById(appartementID);

		String nom = "appartement 003";
		short etage = (short) 5;
		short surface = (short) 100;
		boolean hasParking = false;
		boolean hasCave = true;

		appartement.setNom(nom);
		appartement.setSurface(surface);
		appartement.setEtage(etage);
		appartement.setHasCave(hasCave);
		appartement.setHasParking(hasParking);

		appartementService.updateObject(appartementID, appartement);
		appartement = appartementService.getObjectById(appartementID);
		Assert.assertEquals(appartement.getNom(), nom);
		Assert.assertEquals(appartement.getEtage(), etage);
		Assert.assertEquals(appartement.getSurface(), surface);
		Assert.assertEquals(appartement.isHasCave(), hasCave);
		Assert.assertEquals(appartement.isHasParking(), hasParking);
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testAddDocument() throws Exception {
		Document doc = new Document();
		doc.setNom("new docs");
		doc.setFichier("mon fichier 001");
		DocumentServiceImpl.getInstance().saveObject(doc);
		Assert.assertNotNull(doc.getId());
		documentID = doc.getId();
		appartementService.addDocument(appartementID, documentID);
		Appartement appartement = appartementService.getObjectById(appartementID);
		Assert.assertTrue(appartement.getDocuments().size() == 1);
		for (Document d : appartement.getDocuments()) {
			Assert.assertEquals(d.getId(), documentID);
		}
	}

	@Test(dependsOnMethods = "testAddDocument")
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
		appartementService.setCoordonnees(appartementID, coordonneesID);
		Appartement appartement = appartementService.getObjectById(appartementID);
		Coordonnees c = appartement.getCoordonnees();
		Assert.assertEquals(c.getId(), coordonneesID);
		Assert.assertEquals(c.getAdresse(), coordonnees.getAdresse());
		Assert.assertEquals(c.getAutre(), coordonnees.getAutre());
		Assert.assertEquals(c.getCode_postal(), coordonnees.getCode_postal());
		Assert.assertEquals(c.getEmail(), coordonnees.getEmail());
		Assert.assertEquals(c.getCommentaire(), coordonnees.getCommentaire());
	}

	@Test(dependsOnMethods = "testSetCoordonnees")
	public void testAddTransaction() throws Exception {
		Transaction transaction = new Transaction();
		transaction.setDate(new Date());
		transaction.setMontant((short) 20000);
		transaction.setNeuf(false);
		transaction.setType(Type.ACHAT);
		TransactionServiceImpl.getInstance().saveObject(transaction);
		Assert.assertNotNull(transaction.getId());
		transactionID = transaction.getId();
		appartementService.addTransaction(appartementID, transactionID);
		Appartement appartement = appartementService.getObjectById(appartementID);
		Assert.assertTrue(appartement.getTransactions().size() == 1);
		for (Transaction t : appartement.getTransactions()) {
			Assert.assertEquals(t.getId(), transactionID);
			Assert.assertEquals(t.getMontant(), transaction.getMontant());
			Assert.assertEquals(t.isNeuf(), transaction.isNeuf());
			Assert.assertEquals(t.getType(), transaction.getType());
		}
	}

	@Test(dependsOnMethods = "testAddTransaction")
	public void testAddLocation() throws Exception {
		Location location = new Location();
		location.setCollocation(false);
		location.setDate_debut(new Date());
		location.setDate_fin(new Date());
		location.setMeuble(true);
		LocationServiceImpl.getInstance().saveObject(location);
		Assert.assertNotNull(location.getId());
		locationID = location.getId();
		appartementService.addLocation(appartementID, locationID);
		Appartement appartement = appartementService.getObjectById(appartementID);
		Assert.assertTrue(appartement.getLocations().size() == 1);
		for (Location l : appartement.getLocations()) {
			Assert.assertEquals(l.getId(), locationID);
			Assert.assertEquals(l.isCollocation(), location.isCollocation());
			Assert.assertEquals(l.isMeuble(), location.isMeuble());
		}
	}

	@Test(dependsOnMethods = "testAddLocation")
	public void testAddPiece() throws Exception {
		Piece piece = new Piece();
		piece.setNom("Cuisine");
		piece.setSurface((short) 200);
		PieceServiceImpl.getInstance().saveObject(piece);
		Assert.assertNotNull(piece.getId());
		pieceID = piece.getId();
		appartementService.addPiece(appartementID, pieceID);
		Appartement appartement = appartementService.getObjectById(appartementID);
		Assert.assertTrue(appartement.getPieces().size() == 1);
		for (Piece p : appartement.getPieces()) {
			Assert.assertEquals(p.getId(), pieceID);
			Assert.assertEquals(p.getNom(), piece.getNom());
			Assert.assertEquals(p.getSurface(), piece.getSurface());
		}
	}

	@Test(dependsOnMethods = "testAddPiece")
	public void testAddCharges() throws Exception {
		Charges charges = new Charges();
		charges.setNom("Frais d'agence");
		charges.setDate_echeance(new Date());
		charges.setFrequence(Frequence.ANNUEL);
		charges.setMontant((short) 1000);
		ChargesServiceImpl.getInstance().saveObject(charges);
		Assert.assertNotNull(charges.getId());
		chargesID = charges.getId();
		appartementService.addCharges(appartementID, chargesID);
		Appartement appartement = appartementService.getObjectById(appartementID);
		Assert.assertTrue(appartement.getCharges().size() == 1);
		for (Charges c : appartement.getCharges()) {
			Assert.assertEquals(c.getId(), chargesID);
			Assert.assertEquals(c.getNom(), charges.getNom());
			Assert.assertEquals(c.getMontant(), charges.getMontant());
			Assert.assertEquals(c.getFrequence(), charges.getFrequence());
		}
	}

	@Test(dependsOnMethods = "testAddCharges")
	public void testAddGestionnaire() throws Exception {
		Gestionnaire gestionnaire = new Gestionnaire();
		gestionnaire.setNom("A2BCD");
		gestionnaire.setPrenom("none");
		gestionnaire.setRaison_sociale("Raison sociale");
		GestionnaireServiceImpl.getInstance().saveObject(gestionnaire);
		Assert.assertNotNull(gestionnaire.getId());
		gestionnairesID = gestionnaire.getId();
		appartementService.addGestionnaire(appartementID, gestionnairesID);
		Appartement appartement = appartementService.getObjectById(appartementID);
		Assert.assertTrue(appartement.getGestionnaires().size() == 1);
		for (Gestionnaire g : appartement.getGestionnaires()) {
			Assert.assertEquals(g.getId(), gestionnairesID);
			Assert.assertEquals(g.getNom(), gestionnaire.getNom());
			Assert.assertEquals(g.getPrenom(), gestionnaire.getPrenom());
			Assert.assertEquals(g.getRaison_sociale(), gestionnaire.getRaison_sociale());
		}
	}
	
	@Test(dependsOnMethods = "testAddGestionnaire")
	public void testDelete() {
		// Delete created appartements
		Appartement appartement = appartementService.getObjectById(appartementID);
		Assert.assertNotNull(appartement);
		appartementService.deleteObject(appartementID);
		appartement = appartementService.getObjectById(appartementID);
		Assert.assertNull(appartement);

		// Delete created coordonnees
		Coordonnees coordonnees = CoordonneesServiceImpl.getInstance().getObjectById(coordonneesID);
		Assert.assertNotNull(coordonnees);
		CoordonneesServiceImpl.getInstance().deleteObject(coordonneesID);
		coordonnees = CoordonneesServiceImpl.getInstance().getObjectById(coordonneesID);
		Assert.assertNull(coordonnees);

		// Delete created transaction
		Transaction transaction = TransactionServiceImpl.getInstance().getObjectById(transactionID);
		Assert.assertNotNull(transaction);
		TransactionServiceImpl.getInstance().deleteObject(transactionID);
		transaction = TransactionServiceImpl.getInstance().getObjectById(transactionID);
		Assert.assertNull(transaction);

		// Delete created location
		Location location = LocationServiceImpl.getInstance().getObjectById(locationID);
		Assert.assertNotNull(location);
		LocationServiceImpl.getInstance().deleteObject(locationID);
		location = LocationServiceImpl.getInstance().getObjectById(locationID);
		Assert.assertNull(location);

		// Delete created Piece
		Piece piece = PieceServiceImpl.getInstance().getObjectById(pieceID);
		Assert.assertNotNull(piece);
		PieceServiceImpl.getInstance().deleteObject(pieceID);
		piece = PieceServiceImpl.getInstance().getObjectById(pieceID);
		Assert.assertNull(piece);

		// Delete created Charges
		Charges charges = ChargesServiceImpl.getInstance().getObjectById(chargesID);
		Assert.assertNotNull(charges);
		ChargesServiceImpl.getInstance().deleteObject(chargesID);
		charges = ChargesServiceImpl.getInstance().getObjectById(chargesID);
		Assert.assertNull(charges);

		// Delete created Gestionnaire
		Gestionnaire gestionnaire = GestionnaireServiceImpl.getInstance().getObjectById(gestionnairesID);
		Assert.assertNotNull(gestionnaire);
		GestionnaireServiceImpl.getInstance().deleteObject(gestionnairesID);
		gestionnaire = GestionnaireServiceImpl.getInstance().getObjectById(gestionnairesID);
		Assert.assertNull(gestionnaire);
		
		
		// Delete create documents
		Document doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNotNull(doc);
		DocumentServiceImpl.getInstance().deleteObject(documentID);
		doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNull(doc);
	}

	// @AfterClass()
	// public void clean(){
	// appartementService.delete(appartementID);
	// }
}
