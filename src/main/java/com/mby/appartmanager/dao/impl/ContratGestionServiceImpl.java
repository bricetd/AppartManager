package com.mby.appartmanager.dao.impl;

import com.mby.appartmanager.dao.ContratGestionService;
import com.mby.appartmanager.dao.DocumentService;
import com.mby.appartmanager.dao.OptionsService;
import com.mby.appartmanager.models.ContratGestion;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Options;

public class ContratGestionServiceImpl extends AbstractServiceImpl<ContratGestion> implements ContratGestionService {

private static ContratGestionServiceImpl contratGestionServiceImpl;
private DocumentService documentService;
private OptionsService optionsService;


	private ContratGestionServiceImpl() {
		super(ContratGestion.class);
	}
	
	public static synchronized ContratGestionServiceImpl getInstance() {
		if (null == contratGestionServiceImpl) {
			contratGestionServiceImpl = new ContratGestionServiceImpl();
		}
		return contratGestionServiceImpl;
	}

	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}
	
	public void setOptionsService(OptionsService optionsService) {
		this.optionsService = optionsService;
	}
	
	@Override
	public ContratGestion addDocument(long contratGestionID, long documentID) throws Exception {
		ContratGestion contratGestion = contratGestionServiceImpl.getObjectById(contratGestionID);
		if(null!=contratGestion) {
			Document document = documentService.getObjectById(documentID);
			if(null!=document) {
				contratGestion.addDocument(document);
				contratGestionServiceImpl.updateObject(contratGestionID, contratGestion);
			}
		}
		return contratGestion;
	}
	
	@Override
	public ContratGestion setOptions(long contratGestionID, long optionsID) throws Exception {
		ContratGestion contratGestion = contratGestionServiceImpl.getObjectById(contratGestionID);
		if(null!=contratGestion) {
			Options options = optionsService.getObjectById(optionsID);
			if(null!=options) {
				contratGestion.setOptions(options);
				contratGestionServiceImpl.updateObject(contratGestionID, contratGestion);
			}
		}
		return contratGestion;
	}
}
