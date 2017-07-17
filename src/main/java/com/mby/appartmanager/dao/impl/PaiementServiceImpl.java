package com.mby.appartmanager.dao.impl;

import com.mby.appartmanager.dao.DocumentService;
import com.mby.appartmanager.dao.PaiementService;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Paiement;

public class PaiementServiceImpl extends AbstractServiceImpl<Paiement> implements PaiementService {

private static PaiementServiceImpl paiementServiceImpl;
private DocumentService documentService;


	private PaiementServiceImpl() {
		super(Paiement.class);
	}
	
	public static synchronized PaiementServiceImpl getInstance() {
		if (null == paiementServiceImpl) {
			paiementServiceImpl = new PaiementServiceImpl();
		}
		return paiementServiceImpl;
	}

	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}
	
	@Override
	public Paiement addDocument(long paiementID, long documentID) throws Exception {
		Paiement paiement = paiementServiceImpl.getObjectById(paiementID);
		if(null!=paiement) {
			Document document = documentService.getObjectById(documentID);
			if(null!=document) {
				paiement.addDocument(document);
				paiementServiceImpl.updateObject(paiementID, paiement);
			}
		}
		return paiement;
	}

}
