package com.mby.appartmanager.dao.impl;

import java.util.Date;

import com.mby.appartmanager.dao.TransactionService;
import com.mby.appartmanager.models.Transaction.Type;

public class TransactionServiceImpl implements TransactionService {

	@Override
	public boolean createTransaction(Type type, Date date, boolean isNeuf, short montant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTransaction(int transactionID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setDispositifFiscal(int transactionID, int dispositifFiscalID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addDocument(int transactionID, int documentID) {
		// TODO Auto-generated method stub
		return false;
	}

}
