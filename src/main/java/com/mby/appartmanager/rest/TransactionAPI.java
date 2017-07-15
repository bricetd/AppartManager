package com.mby.appartmanager.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mby.appartmanager.dao.impl.TransactionServiceImpl;
import com.mby.appartmanager.models.Transaction;

import io.swagger.annotations.Api;

@Path("/transaction")
@Api(value = "transaction")
@Produces("application/json")
public class TransactionAPI extends GenericAPI<Transaction>{

	public TransactionAPI() {
		super(TransactionServiceImpl.getInstance());
	}
	
}
