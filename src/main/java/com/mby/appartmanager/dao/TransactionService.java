package com.mby.appartmanager.dao;

import java.util.List;

import com.mby.appartmanager.models.Transaction;

public interface TransactionService {

	public Transaction deleteObject(long transactionID);
	public Transaction getObjectById(long transactionID);
	public List<Transaction> getAllObjects();
	public Transaction updateObject(long transactionID, Transaction transaction) throws Exception;
	public Transaction saveObject(Transaction transaction);
	public Transaction addDocument(long transactionID, long documentID) throws Exception;

}
