package com.mby.appartmanager.models.interfaces;

import java.util.Set;

import com.mby.appartmanager.models.Location;

public interface LocationInterface {

	public Set<Location> getLocations();

	public void setLocations(Set<Location> locations);
	
	public boolean addLocation(Location location);
	
	public boolean removeLocation(Location location);
}
