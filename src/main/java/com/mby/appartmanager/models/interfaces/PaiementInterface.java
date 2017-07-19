package com.mby.appartmanager.models.interfaces;

import java.util.Set;

import com.mby.appartmanager.models.Paiement;

public interface PaiementInterface {

	public Set<Paiement> getPaiements();

	public void setPaiements(Set<Paiement> paiements);
	
	public boolean addPaiement(Paiement paiement);
	
	public boolean removePaiement(Paiement paiement);
}
