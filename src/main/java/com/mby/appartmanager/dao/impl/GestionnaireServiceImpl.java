package com.mby.appartmanager.dao.impl;

import com.mby.appartmanager.dao.ContratGestionService;
import com.mby.appartmanager.dao.CoordonneesService;
import com.mby.appartmanager.dao.GestionnaireService;
import com.mby.appartmanager.models.ContratGestion;
import com.mby.appartmanager.models.Coordonnees;
import com.mby.appartmanager.models.Gestionnaire;

public class GestionnaireServiceImpl extends AbstractServiceImpl<Gestionnaire> implements GestionnaireService {

private static GestionnaireServiceImpl gestionnaireServiceImpl;
private CoordonneesService coordonneesService;
private ContratGestionService contratGestionService;


	private GestionnaireServiceImpl() {
		super(Gestionnaire.class);
	}
	
	public static synchronized GestionnaireServiceImpl getInstance() {
		if (null == gestionnaireServiceImpl) {
			gestionnaireServiceImpl = new GestionnaireServiceImpl();
		}
		return gestionnaireServiceImpl;
	}

	public void setCoordonneesService(CoordonneesService coordonneesService) {
		this.coordonneesService = coordonneesService;
	}
	
	public void setContratGestionService(ContratGestionService contratGestionService) {
		this.contratGestionService = contratGestionService;
	}
	
	public Gestionnaire setCoordonnees(long gestionnaireID, long dispositifFiscalID) throws Exception {
		Gestionnaire gestionnaire = gestionnaireServiceImpl.getObjectById(gestionnaireID);
		if(null!=gestionnaire) {
			Coordonnees dispFiscal = coordonneesService.getObjectById(dispositifFiscalID);
			if(null!=dispFiscal) {
				gestionnaire.setCoordonnees(dispFiscal);
				gestionnaireServiceImpl.updateObject(gestionnaireID, gestionnaire);
			}
		}
		return gestionnaire;
	}

	@Override
	public Gestionnaire addContratGestion(long gestionnaireID, long contratGestionID) throws Exception {
		Gestionnaire gestionnaire = gestionnaireServiceImpl.getObjectById(gestionnaireID);
		if(null!=gestionnaire) {
			ContratGestion contratGestion = contratGestionService.getObjectById(contratGestionID);
			if(null!=contratGestion) {
				gestionnaire.addContratGestion(contratGestion);
				gestionnaireServiceImpl.updateObject(gestionnaireID, gestionnaire);
			}
		}
		return gestionnaire;
	}

}
