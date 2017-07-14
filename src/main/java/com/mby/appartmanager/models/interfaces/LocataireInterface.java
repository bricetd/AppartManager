package com.mby.appartmanager.models.interfaces;

import java.util.List;

import com.mby.appartmanager.models.Locataire;

public interface LocataireInterface {

	public List<Locataire> getLocataires();

	public void setLocataires(List<Locataire> locataires);
	
	public boolean addLocataire(Locataire locataire);
	
	public boolean removeLocataire(Locataire locataire);
}
