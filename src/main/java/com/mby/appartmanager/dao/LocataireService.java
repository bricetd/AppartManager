package com.mby.appartmanager.dao;

import java.util.List;

import com.mby.appartmanager.models.Locataire;

public interface LocataireService {

	public Locataire deleteObject(long locataireID);
	public Locataire getObjectById(long locataireID);
	public List<Locataire> getAllObjects();
	public Locataire updateObject(long locataireID, Locataire locataire) throws Exception;
	public Locataire saveObject(Locataire locataire);
	public Locataire addDocument(long locataireID, long documentID) throws Exception;
	public Locataire setCoordonnees(long locataireID, long coordonneesID)throws Exception;
	public Locataire addPaiement(long locataireID, long paiementID)throws Exception;
	public Locataire addIncident(long locataireID, long incidentID)throws Exception;
}
