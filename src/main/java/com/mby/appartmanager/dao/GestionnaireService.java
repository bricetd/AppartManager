package com.mby.appartmanager.dao;

public interface GestionnaireService {

	public boolean createGestionnaire(String nom, String prenom, String raison_sociale);
	public boolean deleteGestionnaire(int gestionnaireID);
	public boolean setCoordonnees(int gestionnaireID, int coordonneesID);
	public boolean addContratGestion(int gestionnaireID, int contratGestionID);
}
