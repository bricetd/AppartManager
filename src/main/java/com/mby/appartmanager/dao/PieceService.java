package com.mby.appartmanager.dao;

public interface PieceService {

	public boolean createPiece(String nom, short surface);
	public boolean deletePiece(int pieceID);
	public boolean addDocument(int pieceID, int documentID);
	public boolean addEquipement(int pieceID, int equipementID);
}
