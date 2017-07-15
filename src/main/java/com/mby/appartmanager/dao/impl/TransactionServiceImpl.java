package com.mby.appartmanager.dao.impl;

import com.mby.appartmanager.dao.DispositifFiscalService;
import com.mby.appartmanager.dao.DocumentService;
import com.mby.appartmanager.dao.TransactionService;
import com.mby.appartmanager.models.DispositifFiscal;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Transaction;

public class TransactionServiceImpl extends AbstractServiceImpl<Transaction> implements TransactionService {

private static TransactionServiceImpl transactionServiceImpl;
private DispositifFiscalService dispoFiscalService;
private DocumentService documentService;


	private TransactionServiceImpl() {
		super(Transaction.class);
	}
	
	public static synchronized TransactionServiceImpl getInstance() {
		if (null == transactionServiceImpl) {
			transactionServiceImpl = new TransactionServiceImpl();
		}
		return transactionServiceImpl;
	}

	public void setDispoFiscalService(DispositifFiscalService dispoFiscalService) {
		this.dispoFiscalService = dispoFiscalService;
	}
	
	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}
	
	public Transaction setDispositifFiscal(long transactionID, long dispositifFiscalID) throws Exception {
		Transaction transaction = transactionServiceImpl.getObjectById(transactionID);
		if(null!=transaction) {
			DispositifFiscal dispFiscal = dispoFiscalService.getObjectById(dispositifFiscalID);
			if(null!=dispFiscal) {
				transaction.setDispositifFiscal(dispFiscal);
				transactionServiceImpl.updateObject(transactionID, transaction);
			}
		}
		return transaction;
	}

	@Override
	public Transaction addDocument(long transactionID, long documentID) throws Exception {
		Transaction transaction = transactionServiceImpl.getObjectById(transactionID);
		if(null!=transaction) {
			Document document = documentService.getObjectById(documentID);
			if(null!=document) {
				transaction.addDocument(document);
				transactionServiceImpl.updateObject(transactionID, transaction);
			}
		}
		return transaction;
	}

}
