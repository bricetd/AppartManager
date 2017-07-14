package com.mby.appartmanager.dao.impl;

import com.mby.appartmanager.dao.AppartementService;

public class AppartementServiceImpl implements AppartementService{

	@Override
	public boolean createAppartement(String nom, short surface, short etage, boolean hasParking, boolean hasCave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAppartement(int appartementID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTransaction(int appartementID, int transactionID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addLocation(int appartementID, int locationID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPiece(int appartementID, int pieceID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCharge(int appartementID, int chargesID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addGestionnaire(int appartementID, int gestionnaireID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setCoordonnees(int appartementID, int coordonneesID) {
		// TODO Auto-generated method stub
		return false;
	}

}
