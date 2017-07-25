package com.mby.appartmanager.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mby.appartmanager.dao.impl.AppartementServiceImpl;
import com.mby.appartmanager.models.Appartement;

import io.swagger.annotations.Api;

@Path("/appartement")
@Api(value = "appartement")
@Produces("application/json")
public class AppartementAPI extends GenericAPI<Appartement>{

	public AppartementAPI() {
		super(AppartementServiceImpl.getInstance());
	}
	
}
