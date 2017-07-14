package com.mby.appartmanager.dao;

import java.util.Date;

public interface LocationService {

	public boolean createLocation(Date date_debut, Date date_fin, boolean isCollocation,
			boolean isMeuble);
	public boolean deleteLocation(int locationID);
	public boolean addLocataire(int locationID, int locataireID);
	public boolean addDocument(int locationID, int documentID);
}
