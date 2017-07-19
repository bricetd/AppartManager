package com.mby.appartmanager.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mby.appartmanager.dao.impl.IncidentServiceImpl;
import com.mby.appartmanager.models.Incident;

import io.swagger.annotations.Api;

@Path("/incident")
@Api(value = "incident")
@Produces("application/json")
public class IncidentAPI extends GenericAPI<Incident>{
	public IncidentAPI() {
		super(IncidentServiceImpl.getInstance());
	}
}
