package com.mby.appartmanager.dao.impl;

import com.mby.appartmanager.dao.CoordonneesService;
import com.mby.appartmanager.models.Coordonnees;

public class CoordonneesServiceImpl  extends AbstractServiceImpl<Coordonnees> implements CoordonneesService{

private static CoordonneesServiceImpl coordonneesServiceImpl;
	
	private CoordonneesServiceImpl() {
		super(Coordonnees.class);
	}
	

	public static synchronized CoordonneesServiceImpl getInstance() {
		if (null == coordonneesServiceImpl) {
			coordonneesServiceImpl = new CoordonneesServiceImpl();
		}
		return coordonneesServiceImpl;
	}

}
