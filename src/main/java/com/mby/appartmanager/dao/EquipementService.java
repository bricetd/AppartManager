package com.mby.appartmanager.dao;

import java.util.List;

import com.mby.appartmanager.models.Equipement;

public interface EquipementService {


	public Equipement deleteObject(long equipementID);
	public Equipement getObjectById(long equipementID);
	public List<Equipement> getAllObjects();
	public Equipement updateObject(long equipementID, Equipement equipement) throws Exception;
	public Equipement saveObject(Equipement equipement);
	public Equipement addDocument(long equipementID, long documentID) throws Exception;
}
