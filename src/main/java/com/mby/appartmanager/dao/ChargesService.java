package com.mby.appartmanager.dao;

import java.util.Date;

import com.mby.appartmanager.models.Charges.Frequence;

public interface ChargesService {

	public boolean createCharges(String nom, short montant, Frequence frequence, Date date_echeance);
	public boolean deleteCharges(int chargeID);
	public boolean addPaiement(int chargeID, int paiementID);
	public boolean addDocument(int chargeID, int documentID);
}
