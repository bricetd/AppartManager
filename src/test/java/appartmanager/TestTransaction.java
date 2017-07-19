package appartmanager;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mby.appartmanager.dao.TransactionService;
import com.mby.appartmanager.dao.impl.DispositifFiscalServiceImpl;
import com.mby.appartmanager.dao.impl.DocumentServiceImpl;
import com.mby.appartmanager.dao.impl.TransactionServiceImpl;
import com.mby.appartmanager.models.DispositifFiscal;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Transaction;
import com.mby.appartmanager.models.Transaction.Type;

public class TestTransaction {

	private TransactionService transactionService;
	private Transaction.Type type = Type.ACHAT;
	private Date date = new Date();
	private boolean isNeuf = false;
	private short montant = (short)100000;
	private long transactionID;
	private long documentID;
	private long dispFiscalID;

	@BeforeClass
	public void init() {
		TransactionServiceImpl.getInstance().setDocumentService(DocumentServiceImpl.getInstance());
		TransactionServiceImpl.getInstance().setDispoFiscalService(DispositifFiscalServiceImpl.getInstance());
		transactionService = TransactionServiceImpl.getInstance();
	}

	//@Test(dependsOnMethods="delete")
	@Test
	public void testCreate() {
		Transaction transaction = new Transaction();
		transaction.setType(type);
		transaction.setNeuf(isNeuf);
		transaction.setDate(date);
		transaction.setMontant(montant);
		transactionService.saveObject(transaction);
		Assert.assertNotNull(transaction.getId());
		transactionID = transaction.getId();
	}
	
	@Test(dependsOnMethods="testCreate")
	public void testGet() {
		Transaction transaction = transactionService.getObjectById(transactionID);
		Assert.assertEquals(transaction.getType(),type);
		Assert.assertEquals(transaction.isNeuf(),isNeuf);
		Assert.assertEquals(transaction.getMontant(),montant);
		// TODO Manage date format in DB and for tests.
		//Assert.assertEquals(transaction.getDate(),date);
	}
	
	@Test(dependsOnMethods="testGet")
	public void testUpdate() throws Exception {
		Transaction transaction = transactionService.getObjectById(transactionID);
		
		Transaction.Type type = Type.VENTE;
		Date date = new Date();
		boolean isNeuf = true;
		short montant = (short)101111100;
		
		transaction.setType(type);
		transaction.setNeuf(isNeuf);
		transaction.setDate(date);
		transaction.setMontant(montant);
		
		transactionService.updateObject(transactionID,transaction);
		transaction = transactionService.getObjectById(transactionID);
		Assert.assertEquals(transaction.getType(),type);
		Assert.assertEquals(transaction.isNeuf(),isNeuf);
		Assert.assertEquals(transaction.getMontant(),montant);
		//Assert.assertEquals(transaction.getDate(),date);
	}
	
	@Test(dependsOnMethods="testUpdate")
	public void testAddDocument() throws Exception {
		Document doc = new Document();
		doc.setNom("new docs");
		doc.setFichier("mon fichier 001");
		DocumentServiceImpl.getInstance().saveObject(doc);
		Assert.assertNotNull(doc.getId());
		documentID = doc.getId();
		transactionService.addDocument(transactionID, doc.getId());
		Transaction transaction = transactionService.getObjectById(transactionID);
		Assert.assertTrue(transaction.getDocuments().size() == 1);
		for (Document d : transaction.getDocuments()) {
			Assert.assertEquals(d.getId(), doc.getId());
		}
	}
	@Test(dependsOnMethods="testAddDocument")
	public void testSetDispositifFiscal() throws Exception {
		DispositifFiscal dispFisc = new DispositifFiscal();
		dispFisc.setArticles_loi("loi");
		dispFisc.setConditions("conditions");
		dispFisc.setNom("loi pinel");
		dispFisc.setDuree((short)9999);
		DispositifFiscalServiceImpl.getInstance().saveObject(dispFisc);
		Assert.assertNotNull(dispFisc.getId());
		dispFiscalID = dispFisc.getId();
		Transaction transaction = transactionService.getObjectById(transactionID);
		transaction.setDispositifFiscal(dispFisc);
		transactionService.updateObject(transactionID, transaction);
		transaction = transactionService.getObjectById(transactionID);
		Assert.assertEquals(transaction.getDispositifFiscal().getArticles_loi(), dispFisc.getArticles_loi());
		Assert.assertEquals(transaction.getDispositifFiscal().getNom(), dispFisc.getNom());
		Assert.assertEquals(transaction.getDispositifFiscal().getConditions(), dispFisc.getConditions());
		Assert.assertEquals(transaction.getDispositifFiscal().getDuree(), dispFisc.getDuree());
		Assert.assertEquals(transaction.getDispositifFiscal().getId(), dispFisc.getId());
	}
	
	@Test(dependsOnMethods="testSetDispositifFiscal")
	public void testDelete() {
		//Delete created transactions
		Transaction transaction = transactionService.getObjectById(transactionID);
		Assert.assertNotNull(transaction);
		transactionService.deleteObject(transactionID);
		transaction = transactionService.getObjectById(transactionID);
		Assert.assertNull(transaction);
		
		//Delete created dispositifFiscal
		DispositifFiscal dispFisc = DispositifFiscalServiceImpl.getInstance().getObjectById(dispFiscalID);
		Assert.assertNotNull(dispFisc);
		DispositifFiscalServiceImpl.getInstance().deleteObject(dispFiscalID);
		dispFisc = DispositifFiscalServiceImpl.getInstance().getObjectById(dispFiscalID);
		Assert.assertNull(dispFisc);
		
		//Delete create documents
		Document doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNotNull(doc);
		DocumentServiceImpl.getInstance().deleteObject(documentID);
		doc = DocumentServiceImpl.getInstance().getObjectById(documentID);
		Assert.assertNull(doc);
	}
	
//	@AfterClass()
//	public void clean(){
//		transactionService.delete(transactionID);
//	}
}
