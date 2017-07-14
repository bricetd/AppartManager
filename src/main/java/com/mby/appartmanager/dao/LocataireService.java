package com.mby.appartmanager.dao;

import java.util.Date;

import com.mby.appartmanager.models.Locataire.StatusMarital;

public interface LocataireService {

	public boolean createLocataire(String nom, String prenom, Date date_naissance,
			StatusMarital statusMarital, short revenusMensuel, String employeur,
			short anciennete, String cautionnaire);
	public boolean deleteLocataire(int locataireID);
	public boolean setCoordonnees(int locataireID, int coordonneesID);
	public boolean addDocument(int locataireID, int documentID);
	public boolean addPaiement(int locataireID, int paiementID);
	public boolean addIncident(int locataireID, int incidentID);
}
