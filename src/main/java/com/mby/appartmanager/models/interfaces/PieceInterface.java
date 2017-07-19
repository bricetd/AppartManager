package com.mby.appartmanager.models.interfaces;

import java.util.Set;

import com.mby.appartmanager.models.Piece;

public interface PieceInterface {

	public Set<Piece> getPieces();

	public void setPieces(Set<Piece> pieces);
	
	public boolean addPiece(Piece piece);
	
	public boolean removePiece(Piece piece);
}
