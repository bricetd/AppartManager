package com.mby.appartmanager.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.beanutils.BeanUtils;

public class DBSession {

	//private SessionFactory factory;
	private static 	EntityManagerFactory emFactory;
	private static DBSession dbsession;

	private DBSession() {
//		// A SessionFactory is set up once for an application!
//		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings
//																									// from
//																									// hibernate.cfg.xml
//				.build();
//		try {
//			factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//		} catch (Exception e) {
//			// The registry would be destroyed by the SessionFactory, but we had trouble
//			// building the SessionFactory
//			// so destroy it manually.
//			StandardServiceRegistryBuilder.destroy(registry);
//		}
		
		
		emFactory = Persistence.createEntityManagerFactory("com.mby.appartmanager");
		
		
	}

	public static synchronized DBSession getInstance() {
		if (null == dbsession) {
			dbsession = new DBSession();
		}
		return dbsession;
	}

	public Object saveTransactionalObject(Object o) {

		if (null != emFactory) {
			EntityManager entityManager = emFactory.createEntityManager();
			EntityTransaction transaction = null;
			try {
				transaction = entityManager.getTransaction();
				transaction.begin();
				entityManager.persist(o);
				transaction.commit();
			} catch (Exception e) {
				if(null!=transaction) {
					transaction.rollback();
				}
				e.printStackTrace();
				throw e;
			} finally {
				entityManager.close();
			}
		}

		return o;
	}

	// public Object saveTransactionalObject(Object o){
	// if(null!=factory) {
	// Session session = factory.openSession();
	// if(null != session) {
	//
	// Transaction trans = null;
	// try {
	// trans = session.beginTransaction();
	// session.save(o);
	// trans.commit();
	// }
	// catch (Exception e) {
	// if (trans!=null) {
	// trans.rollback();
	// }
	// throw e;
	// }
	// finally {
	// session.close();
	// }
	// }
	// }
	// return o;
	// }
	
	public <T> Object getObjectById(Class<T> clazz, long id) {
		Object obj = null;
		if (null != emFactory) {
			
			EntityManager entityManager = emFactory.createEntityManager();	
			obj = entityManager.find(clazz, id);
			entityManager.close();
			
		}
		return obj;
	}

//	public <T> Object getObjectById(Class<T> clazz, long id) {
//		Object obj = null;
//		if (null != factory) {
//			Session session = factory.openSession();
//			if (null != session) {
//				try {
//					obj = session.get(clazz, id);
//					// cq.select(objectRoot).where(cb.eq(studentRoot.get("id"),id));
//				} catch (Exception e) {
//					throw e;
//				} finally {
//					session.close();
//				}
//			}
//		}
//		return obj;
//	}

	public <T> List<T> getAllObject(Class<T> clazz) {
			//Session session = factory.openSession();
		//	if (null != session) {
			EntityManager em = emFactory.createEntityManager();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<T> cq = cb.createQuery(clazz);
	        Root<T> rootEntry = cq.from(clazz);
	        CriteriaQuery<T> all = cq.select(rootEntry);
	        TypedQuery<T> allQuery = em.createQuery(all);
	        List<T> result = allQuery.getResultList();
	        em.close();
	        return result;
	}
	
	public <T> Object updateObject(Class<T> clazz, long id, Object newObj)
			throws IllegalAccessException, InvocationTargetException {
		Object oldObj = null;
		if (null != emFactory) {
			EntityManager entityManager = emFactory.createEntityManager();	
			oldObj = entityManager.find(clazz, id);
			//start updating
			entityManager.getTransaction().begin();
			BeanUtils.copyProperties(oldObj, newObj);
			entityManager.getTransaction().commit();
			oldObj = entityManager.find(clazz, id);
			entityManager.close();
							
		}
		return oldObj;
	}
	

//	public <T> Object updateObject(Class<T> clazz, long id, Object newObj)
//			throws IllegalAccessException, InvocationTargetException {
//		Object oldObj = null;
//		if (null != emFactory) {
//			if (null != session) {
//				try {
//					Transaction tx = session.beginTransaction();
//					oldObj = session.get(clazz, id);
//					// oldObj = session.load(clazz, id);
//					if (null != oldObj) {
//						BeanUtils.copyProperties(oldObj, newObj);
//						session.update(oldObj);
//						// session.merge(oldObj);
//						session.flush();
//						tx.commit();
//					}
//				} catch (IllegalAccessException | InvocationTargetException e) {
//					System.out.println("");
//					throw e;
//				} finally {
//					session.close();
//				}
//			}
//		}
//		return oldObj;
//	}

//	public <T> Object deleteObject(Class<T> clazz, long id) {
//		Object oldObj = null;
//		if (null != factory) {
//			Session session = factory.openSession();
//			if (null != session) {
//				try {
//					Transaction tx = session.beginTransaction();
//					oldObj = session.get(clazz, id);
//					session.delete(oldObj);
//					tx.commit();
//				} catch (Exception e) {
//					throw e;
//				} finally {
//					session.close();
//				}
//			}
//		}
//		return oldObj;
//	}
	
	public <T> Object deleteObject(Class<T> clazz, long id) {
		Object oldObj = null;
		if (null != emFactory) {
			EntityManager entityManager = emFactory.createEntityManager();	
			oldObj = entityManager.find(clazz, id);
			//start removing
			entityManager.getTransaction().begin();
			entityManager.remove(oldObj);
			entityManager.getTransaction().commit();
			entityManager.close();
					
		}
		return oldObj;
	}
}
