package com.mby.appartmanager.dao;

import java.util.Date;

import com.mby.appartmanager.models.Transaction.Type;

public interface TransactionService {

	public boolean createTransaction(Type type, Date date, boolean isNeuf, short montant);
	public boolean deleteTransaction(int transactionID);
	public boolean setDispositifFiscal(int transactionID, int dispositifFiscalID);
	public boolean addDocument(int transactionID, int documentID);

}
