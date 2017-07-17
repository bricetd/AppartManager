package com.mby.appartmanager.dao.impl;

import com.mby.appartmanager.dao.DocumentService;
import com.mby.appartmanager.dao.EquipementService;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Equipement;

public class EquipementServiceImpl extends AbstractServiceImpl<Equipement> implements EquipementService {

private static EquipementServiceImpl equipementServiceImpl;
private DocumentService documentService;


	private EquipementServiceImpl() {
		super(Equipement.class);
	}
	
	public static synchronized EquipementServiceImpl getInstance() {
		if (null == equipementServiceImpl) {
			equipementServiceImpl = new EquipementServiceImpl();
		}
		return equipementServiceImpl;
	}

	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}
	
	@Override
	public Equipement addDocument(long equipementID, long documentID) throws Exception {
		Equipement equipement = equipementServiceImpl.getObjectById(equipementID);
		if(null!=equipement) {
			Document document = documentService.getObjectById(documentID);
			if(null!=document) {
				equipement.addDocument(document);
				equipementServiceImpl.updateObject(equipementID, equipement);
			}
		}
		return equipement;
	}

}
