package com.mby.appartmanager.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mby.appartmanager.dao.impl.PieceServiceImpl;
import com.mby.appartmanager.models.Piece;

import io.swagger.annotations.Api;

@Path("/piece")
@Api(value = "piece")
@Produces("application/json")
public class PieceAPI extends GenericAPI<Piece>{
	public PieceAPI() {
		super(PieceServiceImpl.getInstance());
	}
}
