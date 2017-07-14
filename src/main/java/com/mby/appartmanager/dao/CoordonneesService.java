package com.mby.appartmanager.dao;

import java.util.List;

import com.mby.appartmanager.models.Coordonnees;

public interface CoordonneesService {

	public Coordonnees deleteObject(long documentID);
	public Coordonnees getObjectById(long id);
	public List<Coordonnees> getAllObjects();
	public Coordonnees updateObject(long id, Coordonnees document) throws Exception;
	public Coordonnees saveObject(Coordonnees document);
}
