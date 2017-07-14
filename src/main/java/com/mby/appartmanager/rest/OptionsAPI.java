package com.mby.appartmanager.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mby.appartmanager.dao.impl.OptionsServiceImpl;
import com.mby.appartmanager.models.Options;

import io.swagger.annotations.Api;

@Path("/options")
@Api(value = "options")
@Produces("application/json")
public class OptionsAPI extends GenericAPI<Options>{

	public OptionsAPI() {
		super(OptionsServiceImpl.getInstance());
	}
	
}
