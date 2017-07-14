package com.mby.appartmanager.dao;

public interface AppartementService {
	
	public boolean createAppartement(String nom, short surface,
			short etage, boolean hasParking, boolean hasCave);

	public boolean deleteAppartement(int appartementID);
	
	public boolean addTransaction(int appartementID, int transactionID);
	
	public boolean addLocation(int appartementID, int locationID);
	
	public boolean addPiece(int appartementID, int pieceID);
	
	public boolean addCharge(int appartementID, int chargesID);
	
	public boolean addGestionnaire(int appartementID,  int gestionnaireID);
	
	public boolean setCoordonnees(int appartementID, int coordonneesID);
}
