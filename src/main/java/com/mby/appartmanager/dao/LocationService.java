package com.mby.appartmanager.dao;

import java.util.List;

import com.mby.appartmanager.models.Location;

public interface LocationService {

	public Location deleteObject(long locationID);
	public Location getObjectById(long locationID);
	public List<Location> getAllObjects();
	public Location updateObject(long locationID, Location location) throws Exception;
	public Location saveObject(Location location);
	public Location addDocument(long locationID, long documentID) throws Exception;
	public Location addLocataire(long locationID, long locataireID) throws Exception;
}
