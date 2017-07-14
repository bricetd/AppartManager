package com.mby.appartmanager.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mby.appartmanager.dao.impl.CoordonneesServiceImpl;
import com.mby.appartmanager.models.Coordonnees;

import io.swagger.annotations.Api;

@Path("/coordonnees")
@Api(value = "coordonnees")
@Produces("application/json")
@Consumes("application/json")
public class CoordonneesAPI extends GenericAPI<Coordonnees>{

	public CoordonneesAPI() {
		super(CoordonneesServiceImpl.getInstance());
	}
}