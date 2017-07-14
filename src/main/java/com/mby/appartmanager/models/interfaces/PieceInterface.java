package com.mby.appartmanager.models.interfaces;

import java.util.List;

import com.mby.appartmanager.models.Piece;

public interface PieceInterface {

	public List<Piece> getPieces();

	public void setPieces(List<Piece> pieces);
	
	public boolean addPiece(Piece piece);
	
	public boolean removePiece(Piece piece);
}
