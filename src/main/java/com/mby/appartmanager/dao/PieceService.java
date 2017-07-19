package com.mby.appartmanager.dao;

import java.util.List;

import com.mby.appartmanager.models.Piece;

public interface PieceService {

	public Piece deleteObject(long pieceID);
	public Piece getObjectById(long pieceID);
	public List<Piece> getAllObjects();
	public Piece updateObject(long pieceID, Piece piece) throws Exception;
	public Piece saveObject(Piece piece);
	public Piece addDocument(long pieceID, long documentID) throws Exception;
	public Piece addEquipement(long pieceID, long equipementID) throws Exception;
}
