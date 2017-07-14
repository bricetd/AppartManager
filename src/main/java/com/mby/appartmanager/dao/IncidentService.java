package com.mby.appartmanager.dao;

import java.util.Date;

public interface IncidentService {

	public boolean createIncident(Date date, Date date_fin, String libelle, String description, String justification);
	public boolean deleteIncident(int incidentID);
	public boolean addDocument(int incidentID, int documentID);
}
