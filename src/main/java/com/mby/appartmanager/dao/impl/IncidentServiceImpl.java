package com.mby.appartmanager.dao.impl;

import com.mby.appartmanager.dao.DocumentService;
import com.mby.appartmanager.dao.IncidentService;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Incident;

public class IncidentServiceImpl  extends AbstractServiceImpl<Incident> implements IncidentService {

private static IncidentServiceImpl incidentServiceImpl;
private DocumentService documentService;


	private IncidentServiceImpl() {
		super(Incident.class);
	}
	
	public static synchronized IncidentServiceImpl getInstance() {
		if (null == incidentServiceImpl) {
			incidentServiceImpl = new IncidentServiceImpl();
		}
		return incidentServiceImpl;
	}

	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}
	
	@Override
	public Incident addDocument(long incidentID, long documentID) throws Exception {
		Incident incident = incidentServiceImpl.getObjectById(incidentID);
		if(null!=incident) {
			Document document = documentService.getObjectById(documentID);
			if(null!=document) {
				incident.addDocument(document);
				incidentServiceImpl.updateObject(incidentID, incident);
			}
		}
		return incident;
	}

}
