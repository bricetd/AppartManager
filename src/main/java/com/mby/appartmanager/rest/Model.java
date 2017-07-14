package com.mby.appartmanager.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mby.appartmanager.models.Appartement;

import io.swagger.annotations.Api;

@Path("/model")
@Api(value = "model")
@Produces("application/json")
public class Model {

	private Logger logger = LogManager.getLogger(Model.class);
//	@POST
//	public Response login(@FormParam("login") String login, @FormParam("password") String password) {
//
//		int httpCode = 500;
//		UserHandler userHandler;
//		UserOperationResult userSaveResult = null;
//		try {
//			userHandler = UserHandler.getInstance();
//			User user = userHandler.getUserByEmail(login);
//			if (user != null) {
//				if (password.equals(user.getPassword())) {
//					userSaveResult = new UserOperationResult(true, "Successfully connected", user);
//				} else {
//					httpCode = 400;
//					userSaveResult = new UserOperationResult(false, "Wrong password");
//				}
//			} else {
//				httpCode = 400;
//				userSaveResult = new UserOperationResult(false, "User not found");
//			}
//			if (userSaveResult.isSuccess()) {
//				httpCode = 200;
//			}
//		} catch (Exception e) {
//			logger.error("Error while logging the user", e);
//			userSaveResult = new UserOperationResult(false, "Server error occured");
//		}
//
//		logger.debug(String.format("Send http message [%s] - %s", httpCode, userSaveResult.getMessage()));
//		return Response.status(httpCode).entity(userSaveResult).build();
//	}

	/*
	@SuppressWarnings("unchecked")
	@GET
	@Path("/{name}")
	public Response getModel(@PathParam("name") String name) {
		DBSession dbSession = DBSession.getInstance();
    	List<Appartement> appartements = dbSession.openSession().createQuery(
    		    "from Appartement")
    		    .list();
    	System.out.println("Nb appts found: "+appartements.size());
		logger.debug(String.format("Send http message [%s] - %s", 200, name));
		
		return Response.status(200).entity(appartements).build();
	}*/
	
	/*private <E> List<E> getModel(Class<E> clazz){
		List<E> result = new ArrayList<E>();
        if(clazz != null){
        	DBSession dbSession = DBSession.getInstance();
        	dbSession.openSession().createQuery(
        		    "from Cat where cat.name = ?")
        		    .setString(0, "")
        		    .list();
//            Query query = mgr.newQuery(MyClass.class);
//            for(E obj : (List<E>)query.execute()) {
//                result.add(obj); 
//            }
        }

        return result;
	}*/
}
