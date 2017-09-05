package com.mby.appartmanager.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
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
		System.out.println("[GET]All of " + serviceHandler.getClass() + " - found:" + objects.size());
		return Response.status(200).entity(objects)
				.build();
//				.header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
//				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

	@GET
	@Path("/{id}")
	public Response getObjectByID(@PathParam("id") final long id) {
		T object = serviceHandler.getObjectById(id);
		System.out.println("[GET]: " + object.getClass() + " id=" + id);
		return Response.status(200).entity(object)
				.build();
//				.header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
//				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

	@PUT
	@Path("/{id}")
	public Response updateObject(@PathParam("id") final long id, final T obj) throws Exception {
		T object = serviceHandler.updateObject(id, obj);
		System.out.println("[PUT]:" + object.getClass() + " id=" + id);
		return Response.status(200).entity(object).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteObject(@PathParam("id") final long id) throws Exception {
		T object = serviceHandler.deleteObject(id);
		System.out.println("[DELETE]:" + object.getClass() + " id=" + id);
		return Response.status(200).entity(object)
				.build();
//				.header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
//				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

	@POST
	@Path("/")
	public Response createObject(final T obj) {
		T object = serviceHandler.saveObject(obj);
		System.out.println("[POST]: new " + object.getClass() + " obj received=" + obj.toString());
		return Response.status(200).entity(object).build();
	}
	
	@OPTIONS
	@Path("/{id}")
	public Response apiOptions(@PathParam("id") final long id) throws Exception {
		System.out.println("[OPTIONS]:" + serviceHandler.getClass()+" id="+id);
		return Response.status(200)
				.build();
//				.header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
//				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
}
