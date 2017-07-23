package com.mby.appartmanager.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mby.appartmanager.dao.impl.ContratGestionServiceImpl;
import com.mby.appartmanager.models.ContratGestion;

import io.swagger.annotations.Api;

@Path("/contratgest")
@Api(value = "contratgest")
@Produces("application/json")
public class ContratGestionAPI extends GenericAPI<ContratGestion>{
	public ContratGestionAPI() {
		super(ContratGestionServiceImpl.getInstance());
	}
}
