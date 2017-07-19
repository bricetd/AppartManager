package com.mby.appartmanager.models.interfaces;

import java.util.Set;

import com.mby.appartmanager.models.Locataire;

public interface LocataireInterface {

	public Set<Locataire> getLocataires();

	public void setLocataires(Set<Locataire> locataires);
	
	public boolean addLocataire(Locataire locataire);
	
	public boolean removeLocataire(Locataire locataire);
}
