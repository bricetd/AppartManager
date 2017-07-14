package com.mby.appartmanager.dao.impl;

import java.util.Date;

import com.mby.appartmanager.dao.ChargesService;
import com.mby.appartmanager.models.Charges.Frequence;

public class ChargesServiceImpl implements ChargesService {

	@Override
	public boolean createCharges(String nom, short montant, Frequence frequence, Date date_echeance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCharges(int chargeID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPaiement(int chargeID, int paiementID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addDocument(int chargeID, int documentID) {
		// TODO Auto-generated method stub
		return false;
	}

}
