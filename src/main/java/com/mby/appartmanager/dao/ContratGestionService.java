package com.mby.appartmanager.dao;

import java.util.Date;

public interface ContratGestionService {

	public boolean createContratGestion(Date date_debut, Date date_fin, short duree, short tariff);
	public boolean deleteContratGestion(int contratGestionID);
	public boolean setOptions(int contratGestionID, int optionsID);
	public boolean addDocument(int contratGestionID, int documentID);
}
