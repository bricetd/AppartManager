package com.mby.appartmanager.models.interfaces;

import java.util.Set;

import com.mby.appartmanager.models.Transaction;

public interface TransactionInterface {

	public Set<Transaction> getTransactions();

	public void setTransactions(Set<Transaction> transactions);
	
	public boolean addTransaction(Transaction Transaction);
	
	public boolean removeTransaction(Transaction Transaction);
}
