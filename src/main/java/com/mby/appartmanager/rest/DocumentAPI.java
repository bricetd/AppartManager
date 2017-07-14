package com.mby.appartmanager.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mby.appartmanager.dao.impl.DocumentServiceImpl;
import com.mby.appartmanager.models.Document;

import io.swagger.annotations.Api;

@Path("/document")
@Api(value = "document")
@Produces("application/json")
public class DocumentAPI extends GenericAPI<Document>{

	public DocumentAPI() {
		super(DocumentServiceImpl.getInstance());
	}
	
}
