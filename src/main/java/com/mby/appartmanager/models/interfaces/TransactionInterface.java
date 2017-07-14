package com.mby.appartmanager.models.interfaces;

import java.util.List;

import com.mby.appartmanager.models.Transaction;

public interface TransactionInterface {

	public List<Transaction> getTransactions();

	public void setTransactions(List<Transaction> transactions);
	
	public boolean addTransaction(Transaction Transaction);
	
	public boolean removeTransaction(Transaction Transaction);
}
