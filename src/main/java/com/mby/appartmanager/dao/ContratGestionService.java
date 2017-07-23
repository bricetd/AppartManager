package com.mby.appartmanager.dao;

import java.util.List;

import com.mby.appartmanager.models.ContratGestion;

public interface ContratGestionService {

	public ContratGestion deleteObject(long contratGestionID);
	public ContratGestion getObjectById(long contratGestionID);
	public List<ContratGestion> getAllObjects();
	public ContratGestion updateObject(long contratGestionID, ContratGestion contratGestion) throws Exception;
	public ContratGestion saveObject(ContratGestion contratGestion);
	public ContratGestion addDocument(long contratGestionID, long documentID) throws Exception;
	public ContratGestion setOptions(long contratGestionID, long optionsID) throws Exception;
}
