package com.mby.appartmanager.dao.impl;

import java.util.Date;

import com.mby.appartmanager.dao.PaiementService;
import com.mby.appartmanager.models.Paiement.Categorie;
import com.mby.appartmanager.models.Paiement.ModePaiement;

public class PaiementServiceImpl implements PaiementService {

	@Override
	public boolean createPaiement(short montant, Date date, Categorie categorie, ModePaiement modePaiement,
			String commentaire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePaiement(int paiementID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addDocument(int paiementID, int documentID) {
		// TODO Auto-generated method stub
		return false;
	}

}
