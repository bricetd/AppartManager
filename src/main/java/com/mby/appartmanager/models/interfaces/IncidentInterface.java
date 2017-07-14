package com.mby.appartmanager.models.interfaces;

import java.util.List;

import com.mby.appartmanager.models.Incident;

public interface IncidentInterface {

	public List<Incident> getIncidents();

	public void setIncidents(List<Incident> incidents);
	
	public boolean addIncident(Incident incident);
	
	public boolean removeIncident(Incident incident);
}
