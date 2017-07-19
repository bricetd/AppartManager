package com.mby.appartmanager.models.interfaces;

import java.util.Set;

import com.mby.appartmanager.models.Equipement;

public interface EquipementInterface {

	public Set<Equipement> getEquipements();

	public void setEquipements(Set<Equipement> equipements);
	
	public boolean addEquipement(Equipement equipement);
	
	public boolean removeEquipement(Equipement equipement);
}
