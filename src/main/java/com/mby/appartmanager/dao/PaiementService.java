package com.mby.appartmanager.dao;

import java.util.Date;

import com.mby.appartmanager.models.Paiement.Categorie;
import com.mby.appartmanager.models.Paiement.ModePaiement;

public interface PaiementService {

	public boolean createPaiement(short montant, Date date, Categorie categorie, ModePaiement modePaiement, String commentaire);
	public boolean deletePaiement(int paiementID);
	public boolean addDocument(int paiementID, int documentID);
}
