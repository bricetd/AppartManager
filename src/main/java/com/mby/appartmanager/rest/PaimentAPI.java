package com.mby.appartmanager.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mby.appartmanager.dao.impl.PaiementServiceImpl;
import com.mby.appartmanager.models.Paiement;

import io.swagger.annotations.Api;

@Path("/paiement")
@Api(value = "paiement")
@Produces("application/json")
public class PaimentAPI extends GenericAPI<Paiement>{
	public PaimentAPI() {
		super(PaiementServiceImpl.getInstance());
	}
}
