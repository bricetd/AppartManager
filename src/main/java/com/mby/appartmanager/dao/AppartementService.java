package com.mby.appartmanager.dao;

import java.util.List;

import com.mby.appartmanager.models.Appartement;

public interface AppartementService {
	
	public Appartement deleteObject(long appartementID);
	public Appartement getObjectById(long appartementID);
	public List<Appartement> getAllObjects();
	public Appartement updateObject(long appartementID, Appartement appartement) throws Exception;
	public Appartement saveObject(Appartement appartement);
	public Appartement addDocument(long appartementID, long documentID) throws Exception;
	public Appartement addTransaction(long appartementID, long transactionID) throws Exception;
	public Appartement addLocation(long appartementID, long locationID) throws Exception;
	public Appartement addPiece(long appartementID, long pieceID) throws Exception;
	public Appartement addCharges(long appartementID, long chargesID) throws Exception;
	public Appartement addGestionnaire(long appartementID, long gestionnaireID) throws Exception;
	public Appartement setCoordonnees(long appartementID, long coordonneesID) throws Exception;
}
