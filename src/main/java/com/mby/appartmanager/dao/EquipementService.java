package com.mby.appartmanager.dao;

import java.util.Date;

public interface EquipementService {

	public boolean createEquipement(String nom, short valeur, Date date_achat);
	public boolean deleteEquipement(int equipementID);
	public boolean addDocument(int equipementID, int documentID);
}
