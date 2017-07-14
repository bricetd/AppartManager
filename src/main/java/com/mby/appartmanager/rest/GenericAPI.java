package com.mby.appartmanager.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.mby.appartmanager.dao.impl.AbstractServiceImpl;

public abstract class GenericAPI<T> {

	private AbstractServiceImpl<T> serviceHandler;
	
	protected GenericAPI(final AbstractServiceImpl<T> serviceHandler) {
		this.serviceHandler = serviceHandler;
	}
	
	@GET
	@Path("/")
	public Response getAllObjects() {
		List<T> objects = serviceHandler.getAllObjects();
    	System.out.println("[ALL]NB Docs founds: "+objects.size());
		return Response.status(200).entity(objects).build();
	}
	
	@GET
	@Path("/{id}")
	public Response getObjectByID(@PathParam("id") final long id) {
		T object = serviceHandler.getObjectById(id);
		return Response.status(200).entity(object).build();
	}
	
	@PUT
	@Path("/{id}")
	public Response updateObject(@PathParam("id") final long id, final T doc) throws Exception {
		T object = serviceHandler.updateObject(id, doc);
		return Response.status(200).entity(object).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteObject(@PathParam("id") final long id) throws Exception {
		T object = serviceHandler.deleteObject(id);
		return Response.status(200).entity(object).build();
	}
	
	@POST
	@Path("/")
	public Response createObject(final T doc) {
		T object = serviceHandler.saveObject(doc);
		return Response.status(200).entity(object).build();
	}
}
