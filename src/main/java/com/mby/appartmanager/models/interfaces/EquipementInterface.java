package com.mby.appartmanager.models.interfaces;

import java.util.List;

import com.mby.appartmanager.models.Equipement;

public interface EquipementInterface {

	public List<Equipement> getEquipements();

	public void setEquipements(List<Equipement> equipements);
	
	public boolean addEquipement(Equipement equipement);
	
	public boolean removeEquipement(Equipement equipement);
}
