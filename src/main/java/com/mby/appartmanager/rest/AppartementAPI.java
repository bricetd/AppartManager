package com.mby.appartmanager.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.mby.appartmanager.dao.AppartementService;
import com.mby.appartmanager.dao.impl.AppartementServiceImpl;
import com.mby.appartmanager.dao.impl.DocumentServiceImpl;
import com.mby.appartmanager.models.Appartement;
import com.mby.appartmanager.models.Document;

import io.swagger.annotations.Api;

@Path("/appartement")
@Api(value = "appartement")
@Produces("application/json")
public class AppartementAPI extends GenericAPI<Appartement>{

	private final AppartementService appartementService = AppartementServiceImpl.getInstance();
	public AppartementAPI() {
		super(AppartementServiceImpl.getInstance());
		AppartementServiceImpl.getInstance().setDocumentService(DocumentServiceImpl.getInstance());
	}
	
	@GET
	@Path("/{id}/documents")
	public Response getAppartementDocuments(@PathParam("id") final long appartementID) throws Exception {
		Object object = appartementService.getAppartementDocuments(appartementID);
		return Response.status(200).entity(object).build();
	}
	
	@POST
	@Path("/{id}/document")
	public Response addDocument(@PathParam("id") final long appartementID, final Document document) throws Exception {
		Document savedDoc = DocumentServiceImpl.getInstance().saveObject(document);
		Object object = null;
		if(null!=savedDoc) {
			object  = appartementService.addDocument(appartementID, savedDoc.getId());
		}
		System.out.println("[POST]: new " + object.getClass() + " obj received=" + document.toString());
		return Response.status(200).entity(object).build();
	}
	
}
