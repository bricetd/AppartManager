package com.mby.appartmanager.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mby.appartmanager.dao.impl.EquipementServiceImpl;
import com.mby.appartmanager.models.Equipement;

import io.swagger.annotations.Api;

@Path("/equipement")
@Api(value = "equipement")
@Produces("application/json")
public class EquipementAPI extends GenericAPI<Equipement>{
	public EquipementAPI() {
		super(EquipementServiceImpl.getInstance());
	}
}
