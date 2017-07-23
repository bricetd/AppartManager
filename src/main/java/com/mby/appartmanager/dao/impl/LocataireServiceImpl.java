package com.mby.appartmanager.dao.impl;

import com.mby.appartmanager.dao.CoordonneesService;
import com.mby.appartmanager.dao.DocumentService;
import com.mby.appartmanager.dao.IncidentService;
import com.mby.appartmanager.dao.LocataireService;
import com.mby.appartmanager.dao.PaiementService;
import com.mby.appartmanager.models.Coordonnees;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Incident;
import com.mby.appartmanager.models.Locataire;
import com.mby.appartmanager.models.Paiement;

public class LocataireServiceImpl  extends AbstractServiceImpl<Locataire> implements LocataireService {

private static LocataireServiceImpl locataireServiceImpl;
private CoordonneesService coordonneesService;
private DocumentService documentService;
private IncidentService incidentService;
private PaiementService paiementService;


	private LocataireServiceImpl() {
		super(Locataire.class);
	}
	
	public static synchronized LocataireServiceImpl getInstance() {
		if (null == locataireServiceImpl) {
			locataireServiceImpl = new LocataireServiceImpl();
		}
		return locataireServiceImpl;
	}

	public void setCoordonneesService(CoordonneesService coordonneesService) {
		this.coordonneesService = coordonneesService;
	}
	
	public void setIncidentService(IncidentService incidentService) {
		this.incidentService = incidentService;
	}
	
	public void setPaiementService(PaiementService paiementService) {
		this.paiementService = paiementService;
	}
	
	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}
	
	public Locataire setCoordonnees(long locataireID, long dispositifFiscalID) throws Exception {
		Locataire locataire = locataireServiceImpl.getObjectById(locataireID);
		if(null!=locataire) {
			Coordonnees dispFiscal = coordonneesService.getObjectById(dispositifFiscalID);
			if(null!=dispFiscal) {
				locataire.setCoordonnees(dispFiscal);
				locataireServiceImpl.updateObject(locataireID, locataire);
			}
		}
		return locataire;
	}

	@Override
	public Locataire addDocument(long locataireID, long documentID) throws Exception {
		Locataire locataire = locataireServiceImpl.getObjectById(locataireID);
		if(null!=locataire) {
			Document document = documentService.getObjectById(documentID);
			if(null!=document) {
				locataire.addDocument(document);
				locataireServiceImpl.updateObject(locataireID, locataire);
			}
		}
		return locataire;
	}

	@Override
	public Locataire addPaiement(long locataireID, long paiementID) throws Exception {
		Locataire locataire = locataireServiceImpl.getObjectById(locataireID);
		if(null!=locataire) {
			Paiement paiement = paiementService.getObjectById(paiementID);
			if(null!=paiement) {
				locataire.addPaiement(paiement);
				locataireServiceImpl.updateObject(locataireID, locataire);
			}
		}
		return locataire;
	}

	@Override
	public Locataire addIncident(long locataireID, long incidentID) throws Exception {
		Locataire locataire = locataireServiceImpl.getObjectById(locataireID);
		if(null!=locataire) {
			Incident incident = incidentService.getObjectById(incidentID);
			if(null!=incident) {
				locataire.addIncident(incident);
				locataireServiceImpl.updateObject(locataireID, locataire);
			}
		}
		return locataire;
	}

}
