package com.mby.appartmanager.models.interfaces;

import java.util.Set;

import com.mby.appartmanager.models.Incident;

public interface IncidentInterface {

	public Set<Incident> getIncidents();

	public void setIncidents(Set<Incident> incidents);
	
	public boolean addIncident(Incident incident);
	
	public boolean removeIncident(Incident incident);
}
