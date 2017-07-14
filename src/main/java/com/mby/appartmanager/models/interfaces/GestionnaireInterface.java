package com.mby.appartmanager.models.interfaces;

import java.util.List;

import com.mby.appartmanager.models.Gestionnaire;

public interface GestionnaireInterface {

	public List<Gestionnaire> getGestionnaires();

	public void setGestionnaires(List<Gestionnaire> gestionnaires);
	
	public boolean addGestionnaire(Gestionnaire gestionnaire);
	
	public boolean removeGestionnaire(Gestionnaire gestionnaire);
}
