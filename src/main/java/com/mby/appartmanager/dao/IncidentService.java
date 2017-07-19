package com.mby.appartmanager.dao;

import java.util.List;

import com.mby.appartmanager.models.Incident;

public interface IncidentService {

	public Incident deleteObject(long incidentID);
	public Incident getObjectById(long incidentID);
	public List<Incident> getAllObjects();
	public Incident updateObject(long incidentID, Incident incident) throws Exception;
	public Incident saveObject(Incident incident);
	public Incident addDocument(long incidentID, long documentID) throws Exception;
}
