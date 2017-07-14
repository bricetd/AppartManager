package com.mby.appartmanager.dao.impl;

import java.util.Date;

import com.mby.appartmanager.dao.LocataireService;
import com.mby.appartmanager.models.Locataire.StatusMarital;

public class LocataireServiceImpl implements LocataireService {

	@Override
	public boolean createLocataire(String nom, String prenom, Date date_naissance, StatusMarital statusMarital,
			short revenusMensuel, String employeur, short anciennete, String cautionnaire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLocataire(int locataireID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setCoordonnees(int locataireID, int coordonneesID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addDocument(int locataireID, int documentID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPaiement(int locataireID, int paiementID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addIncident(int locataireID, int incidentID) {
		// TODO Auto-generated method stub
		return false;
	}

}
