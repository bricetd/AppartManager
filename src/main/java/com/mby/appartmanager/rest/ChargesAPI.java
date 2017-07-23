package com.mby.appartmanager.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mby.appartmanager.dao.impl.ChargesServiceImpl;
import com.mby.appartmanager.models.Charges;

import io.swagger.annotations.Api;

@Path("/charges")
@Api(value = "charges")
@Produces("application/json")
public class ChargesAPI extends GenericAPI<Charges>{

	public ChargesAPI() {
		super(ChargesServiceImpl.getInstance());
	}
	
}
