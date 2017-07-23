package com.mby.appartmanager.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mby.appartmanager.dao.impl.LocataireServiceImpl;
import com.mby.appartmanager.models.Locataire;

import io.swagger.annotations.Api;

@Path("/locataire")
@Api(value = "locataire")
@Produces("application/json")
public class LocataireAPI extends GenericAPI<Locataire>{

	public LocataireAPI() {
		super(LocataireServiceImpl.getInstance());
	}
	
}
