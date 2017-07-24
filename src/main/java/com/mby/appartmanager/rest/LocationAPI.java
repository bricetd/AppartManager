package com.mby.appartmanager.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mby.appartmanager.dao.impl.LocationServiceImpl;
import com.mby.appartmanager.models.Location;

import io.swagger.annotations.Api;

@Path("/location")
@Api(value = "location")
@Produces("application/json")
public class LocationAPI extends GenericAPI<Location>{
	public LocationAPI() {
		super(LocationServiceImpl.getInstance());
	}
}
