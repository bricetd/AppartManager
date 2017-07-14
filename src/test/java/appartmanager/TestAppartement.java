package appartmanager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mby.appartmanager.models.Appartement;
import com.mby.appartmanager.models.Coordonnees;

public class TestAppartement {

	private SessionFactory factory;

	@BeforeClass
	public void init() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
			deleteAppartement();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	//@Test(dependsOnMethods="deleteAppartement")
	@Test
	public void createAppartement() {
		Session session = factory.openSession();
		session.beginTransaction();
		Appartement appt = new Appartement("profil1", (short)0, (short)0, false, false);
		Coordonnees coor = new Coordonnees();
		coor.setAdresse("Montigny les cormeilles");
		coor.setFixe("+3312233884848");
		appt.setCoordonnees(coor);
		session.save(appt);
		session.getTransaction().commit();
		session.close();
	}
	
	@AfterClass
	public void clean(){
		//deleteAppartement();
	}
	
	@SuppressWarnings("unchecked")
	public void deleteAppartement() {
		Session session = factory.openSession();
		session.beginTransaction();
		List<Appartement> appartements = session.createQuery("FROM Appartement").list();
		for(Appartement appart: appartements){
			session.delete(appart);
		}
		session.getTransaction().commit();
		session.close();
	}
}
