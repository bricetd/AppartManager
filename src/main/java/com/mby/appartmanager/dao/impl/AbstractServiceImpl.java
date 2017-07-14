package com.mby.appartmanager.dao.impl;

import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractServiceImpl<T> {

	private Class<T> clazz;
	
	protected AbstractServiceImpl(final Class<T> clazz) {
		this.clazz = clazz;
	}
	//@Override
	public T saveObject(T object) {
		return  (T) DBSession.getInstance().saveTransactionalObject(object);
	}

	//@Override
	public T deleteObject(long objectID) {
		return (T) DBSession.getInstance().deleteObject(clazz, objectID);
	}
	
	//@Override
	public T getObjectById(long id) {

		return (T) DBSession.getInstance().getObjectById(clazz, id);
	}
	
	//@Override
	public List<T> getAllObjects(){
		return (List<T>) DBSession.getInstance().getAllObject(clazz);
	}
	
	//@Override
	public T updateObject(long id, T object) throws Exception {
		T result = null;
		if(null!=object) {
			result = (T) DBSession.getInstance().updateObject(clazz, id, object);
		}else {
			System.out.println("Error : request to update a null doc");
		}
		return result;
	}
	
}
