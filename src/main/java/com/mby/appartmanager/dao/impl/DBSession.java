package com.mby.appartmanager.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DBSession {

	private SessionFactory factory;
	private static DBSession dbsession;

	private DBSession() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static synchronized DBSession getInstance() {
		if (null == dbsession) {
			dbsession = new DBSession();
		}
		return dbsession;
	}
	
	public Object saveTransactionalObject(Object o){
		if(null!=factory) {
			Session session = factory.openSession();
			if(null != session) {
				
				Transaction trans = null;
				 try {
					 trans = session.beginTransaction();
					 session.save(o);
				     trans.commit();
				 }
				 catch (Exception e) {
				     if (trans!=null) {
				    	 trans.rollback();
				     }
				     throw e;
				 }
				 finally {
				     session.close();
				 }
			}
		}
		return o;
	}
	
	public <T> Object getObjectById(Class<T> clazz, long id){
		Object obj = null;
		if(null!=factory) {
			Session session = factory.openSession();
			if(null != session) {
				 try {
					 obj=session.get(clazz, id);
				 }
				 catch (Exception e) {
				     throw e;
				 }
				 finally {
				     session.close();
				 }
			}
		}
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getAllObject(Class<T> clazz){
		List<T> obj = null;
		if(null!=factory) {
			Session session = factory.openSession();
			if(null != session) {
				 try {
					 obj=session.createCriteria(clazz).list();
				 }
				 catch (Exception e) {
				     throw e;
				 }
				 finally {
				     session.close();
				 }
			}
		}
		return obj;
	}

	public <T> Object updateObject(Class<T> clazz, long id, Object newObj) throws IllegalAccessException, InvocationTargetException {
		Object oldObj = null;
		if(null!=factory) {
			Session session = factory.openSession();
			if(null != session) {
				 try {
					 Transaction tx = session.beginTransaction();
					 oldObj = session.get(clazz, id);
//					 oldObj = session.load(clazz, id);
					 if(null!=oldObj) {
						 BeanUtils.copyProperties(oldObj, newObj);
						 session.update(oldObj);
//						 session.merge(oldObj);
//						 session.flush();
						 tx.commit();
					 }
				 }
				 catch (IllegalAccessException | InvocationTargetException e) {
					 System.out.println("");
				     throw e;
				 }
				 finally {
				     session.close();
				 }
			}
		}
		return oldObj;
	}
	
	public <T> Object deleteObject(Class<T> clazz, long id) {
		Object oldObj = null;
		if(null!=factory) {
			Session session = factory.openSession();
			if(null != session) {
				 try {
					 Transaction tx = session.beginTransaction();
					 oldObj = session.get(clazz, id);
					 session.delete(oldObj);
					 tx.commit();
				 }
				 catch (Exception e) {
				     throw e;
				 }
				 finally {
				     session.close();
				 }
			}
		}
		return oldObj;
	}
}
