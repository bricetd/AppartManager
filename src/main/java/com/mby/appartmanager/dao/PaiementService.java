package com.mby.appartmanager.dao;

import java.util.List;

import com.mby.appartmanager.models.Paiement;

public interface PaiementService {

	public Paiement deleteObject(long paiementID);
	public Paiement getObjectById(long paiementID);
	public List<Paiement> getAllObjects();
	public Paiement updateObject(long paiementID, Paiement paiement) throws Exception;
	public Paiement saveObject(Paiement paiement);
	public Paiement addDocument(long paiementID, long documentID) throws Exception;
}
