package com.mby.appartmanager.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mby.appartmanager.dao.impl.GestionnaireServiceImpl;
import com.mby.appartmanager.models.Gestionnaire;

import io.swagger.annotations.Api;

@Path("/gestionnaire")
@Api(value = "gestionnaire")
@Produces("application/json")
public class GestionnaireAPI extends GenericAPI<Gestionnaire>{
	public GestionnaireAPI() {
		super(GestionnaireServiceImpl.getInstance());
	}
}
