package com.mby.appartmanager.dao.impl;

import com.mby.appartmanager.dao.DocumentService;
import com.mby.appartmanager.dao.EquipementService;
import com.mby.appartmanager.dao.PieceService;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Equipement;
import com.mby.appartmanager.models.Piece;

public class PieceServiceImpl extends AbstractServiceImpl<Piece> implements PieceService {

private static PieceServiceImpl pieceServiceImpl;
private DocumentService documentService;
private EquipementService equipementService;


	private PieceServiceImpl() {
		super(Piece.class);
	}
	
	public static synchronized PieceServiceImpl getInstance() {
		if (null == pieceServiceImpl) {
			pieceServiceImpl = new PieceServiceImpl();
		}
		return pieceServiceImpl;
	}

	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}
	
	public void setEquipementService(EquipementService equipementService) {
		this.equipementService = equipementService;
	}
	
	@Override
	public Piece addDocument(long pieceID, long documentID) throws Exception {
		Piece piece = pieceServiceImpl.getObjectById(pieceID);
		if(null!=piece) {
			Document document = documentService.getObjectById(documentID);
			if(null!=document) {
				piece.addDocument(document);
				pieceServiceImpl.updateObject(pieceID, piece);
			}
		}
		return piece;
	}
	
	@Override
	public Piece addEquipement(long pieceID, long equipementID) throws Exception {
		Piece piece = pieceServiceImpl.getObjectById(pieceID);
		if(null!=piece) {
			Equipement equipement = equipementService.getObjectById(equipementID);
			if(null!=equipement) {
				piece.addEquipement(equipement);
				pieceServiceImpl.updateObject(pieceID, piece);
			}
		}
		return piece;
	}
}
