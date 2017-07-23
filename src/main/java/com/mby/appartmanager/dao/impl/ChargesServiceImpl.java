package com.mby.appartmanager.dao.impl;

import com.mby.appartmanager.dao.ChargesService;
import com.mby.appartmanager.dao.DocumentService;
import com.mby.appartmanager.dao.PaiementService;
import com.mby.appartmanager.models.Charges;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Paiement;

public class ChargesServiceImpl extends AbstractServiceImpl<Charges> implements ChargesService {

private static ChargesServiceImpl chargesServiceImpl;
private DocumentService documentService;
private PaiementService paiementService;


	private ChargesServiceImpl() {
		super(Charges.class);
	}
	
	public static synchronized ChargesServiceImpl getInstance() {
		if (null == chargesServiceImpl) {
			chargesServiceImpl = new ChargesServiceImpl();
		}
		return chargesServiceImpl;
	}

	public void setPaiementService(PaiementService paiementService) {
		this.paiementService = paiementService;
	}
	
	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}

	@Override
	public Charges addDocument(long chargesID, long documentID) throws Exception {
		Charges charges = chargesServiceImpl.getObjectById(chargesID);
		if(null!=charges) {
			Document document = documentService.getObjectById(documentID);
			if(null!=document) {
				charges.addDocument(document);
				chargesServiceImpl.updateObject(chargesID, charges);
			}
		}
		return charges;
	}

	@Override
	public Charges addPaiement(long chargesID, long paiementID) throws Exception {
		Charges charges = chargesServiceImpl.getObjectById(chargesID);
		if(null!=charges) {
			Paiement paiement = paiementService.getObjectById(paiementID);
			if(null!=paiement) {
				charges.addPaiement(paiement);
				chargesServiceImpl.updateObject(chargesID, charges);
			}
		}
		return charges;
	}

}
