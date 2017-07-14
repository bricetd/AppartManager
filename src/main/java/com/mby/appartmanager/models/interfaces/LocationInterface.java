package com.mby.appartmanager.models.interfaces;

import java.util.List;

import com.mby.appartmanager.models.Location;

public interface LocationInterface {

	public List<Location> getLocations();

	public void setLocations(List<Location> locations);
	
	public boolean addLocation(Location location);
	
	public boolean removeLocation(Location location);
}
