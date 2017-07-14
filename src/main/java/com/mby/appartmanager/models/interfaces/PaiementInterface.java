package com.mby.appartmanager.models.interfaces;

import java.util.List;

import com.mby.appartmanager.models.Paiement;

public interface PaiementInterface {

	public List<Paiement> getPaiements();

	public void setPaiements(List<Paiement> paiements);
	
	public boolean addPaiement(Paiement paiement);
	
	public boolean removePaiement(Paiement paiement);
}
