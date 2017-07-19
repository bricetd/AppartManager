package appartmanager;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mby.appartmanager.dao.PieceService;
import com.mby.appartmanager.dao.impl.DocumentServiceImpl;
import com.mby.appartmanager.dao.impl.EquipementServiceImpl;
import com.mby.appartmanager.dao.impl.PieceServiceImpl;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Equipement;
import com.mby.appartmanager.models.Piece;

public class TestPiece {

	private PieceService pieceService;
	private String nom = "salon";
	private int surface = 10;
	private long pieceID;
	private long documentID;
	private long equipementID;

	@BeforeClass
	public void init() {
		PieceServiceImpl.getInstance().setDocumentService(DocumentServiceImpl.getInstance());
		PieceServiceImpl.getInstance().setEquipementService(EquipementServiceImpl.getInstance());
		pieceService = PieceServiceImpl.getInstance();
	}

	// @Test(dependsOnMethods="delete")
	@Test
	public void testCreate() {
		Piece piece = new Piece();
		piece.setNom(nom);
		piece.setSurface(surface);
		pieceService.saveObject(piece);
		Assert.assertNotNull(piece.getId());
		pieceID = piece.getId();
	}

	@Test(dependsOnMethods = "testCreate")
	public void testGet() {
		Piece piece = pieceService.getObjectById(pieceID);
		Assert.assertEquals(piece.getNom(), nom);
		Assert.assertEquals(piece.getSurface(), surface);
	}

	@Test(dependsOnMethods = "testGet")
	public void testUpdate() throws Exception {
		Piece piece = pieceService.getObjectById(pieceID);

		String nom = "salon";
		int surface = 10;

		piece.setNom(nom);
		piece.setSurface(surface);

		pieceService.updateObject(pieceID, piece);
		piece = pieceService.getObjectById(pieceID);

		Assert.assertEquals(piece.getNom(), nom);
		Assert.assertEquals(piece.getSurface(), surface);
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testAddDocument() throws Exception {
		Document doc = new Document();
		doc.setNom("new docs");
		doc.setFichier("mon fichier 001");
		DocumentServiceImpl.getInstance().saveObject(doc);
		Assert.assertNotNull(doc.getId());
		documentID = doc.getId();
		pieceService.addDocument(pieceID, doc.getId());
		Piece piece = pieceService.getObjectById(pieceID);
		Assert.assertTrue(piece.getDocuments().size() == 1);
		for (Document d : piece.getDocuments()) {
			Assert.assertEquals(d.getId(), doc.getId());
		}
	}

	@Test(dependsOnMethods = "testAddDocument")
	public void testAddEquipement() throws Exception {
		Equipement equipement = new Equipement();
		equipement.setNom("microonde");
		equipement.setDate_achat(new Date());
		equipement.setValeur((short) 10);
		EquipementServiceImpl.getInstance().saveObject(equipement);
		Assert.assertNotNull(equipement.getId());
		equipementID = equipement.getId();
		pieceService.addEquipement(pieceID, equipement.getId());
		Piece piece = pieceService.getObjectById(pieceID);
		Assert.assertTrue(piece.getEquipements().size() == 1);
		for (Equipement e : piece.getEquipements()) {
			Assert.assertEquals(e.getId(), equipement.getId());
		}
	}

	@Test(dependsOnMethods = "testAddEquipement")
	public void testDelete() {
		// Delete created pieces
		Piece piece = pieceService.getObjectById(pieceID);
		Assert.assertNotNull(piece);
		pieceService.deleteObject(pieceID);
		piece = pieceService.getObjectById(pieceID);
		Assert.assertNull(piece);

		// Delete created equipements
		Equipement equipement = EquipementServiceImpl.getInstance().getObjectById(equipementID);
		Assert.assertNotNull(equipement);
		EquipementServiceImpl.getInstance().deleteObject(equipementID);
		equipement = EquipementServiceImpl.getInstance().getObjectById(equipementID);
		Assert.assertNull(equipement);

		// Delete created documents
		Document doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNotNull(doc);
		DocumentServiceImpl.getInstance().deleteObject(documentID);
		doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNull(doc);
	}

	// @AfterClass()
	// public void clean(){
	// pieceService.delete(pieceID);
	// }
}
