package com.mby.appartmanager.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mby.appartmanager.dao.impl.DispositifFiscalServiceImpl;
import com.mby.appartmanager.models.DispositifFiscal;

import io.swagger.annotations.Api;

@Path("/dispfiscal")
@Api(value = "dispfiscal")
@Produces("application/json")
@Consumes("application/json")
public class DispositifFiscalAPI extends GenericAPI<DispositifFiscal>{

		public DispositifFiscalAPI() {
			super(DispositifFiscalServiceImpl.getInstance());
		}

}
