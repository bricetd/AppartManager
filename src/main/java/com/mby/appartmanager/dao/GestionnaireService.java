package com.mby.appartmanager.dao;

import java.util.List;

import com.mby.appartmanager.models.Gestionnaire;

public interface GestionnaireService {

	public Gestionnaire deleteObject(long gestionnaireID);
	public Gestionnaire getObjectById(long gestionnaireID);
	public List<Gestionnaire> getAllObjects();
	public Gestionnaire updateObject(long gestionnaireID, Gestionnaire gestionnaire) throws Exception;
	public Gestionnaire saveObject(Gestionnaire gestionnaire);
	public Gestionnaire setCoordonnees(long gestionnaireID, long coordonneesID)throws Exception;
	public Gestionnaire addContratGestion(long gestionnaireID, long contratGestionID)throws Exception;
}
