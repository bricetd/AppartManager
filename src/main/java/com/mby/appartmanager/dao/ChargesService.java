package com.mby.appartmanager.dao;

import java.util.List;

import com.mby.appartmanager.models.Charges;

public interface ChargesService {

	public Charges deleteObject(long chargesID);
	public Charges getObjectById(long chargesID);
	public List<Charges> getAllObjects();
	public Charges updateObject(long chargesID, Charges charges) throws Exception;
	public Charges saveObject(Charges charges);
	public Charges addDocument(long chargesID, long documentID) throws Exception;
	public Charges addPaiement(long chargesID, long paiementID)throws Exception;
}
