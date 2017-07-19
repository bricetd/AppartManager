package com.mby.appartmanager.models.interfaces;

import java.util.Set;

import com.mby.appartmanager.models.Gestionnaire;

public interface GestionnaireInterface {

	public Set<Gestionnaire> getGestionnaires();

	public void setGestionnaires(Set<Gestionnaire> gestionnaires);
	
	public boolean addGestionnaire(Gestionnaire gestionnaire);
	
	public boolean removeGestionnaire(Gestionnaire gestionnaire);
}
