package castellet.dam.m12.uf2.hibernate;
//C:\Program Files\Common Files\Oracle\Java\javapath


//import java.lang.System.Logger.Level;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class App {
	static SessionFactory sessionFactory = null;
	static Session session = null;
	
	public static void tearUp() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	public static void tearDown() {
		session.close();
	}
	
	public static void comprobarSesion() {
		if (session != null) {
			System.out.println("Sesión abierta");
		} else {
			System.out.println("Fallo en la sesión");
		}
	}
	
	public static void mostraSports() {
		Query<Sports> consulta =  session.createQuery("from sports", Sports.class);
		//Query<Sports> consulta =  session.createQuery();
		java.util.List<Sports> results = consulta.list();
		System.out.println("Mostrant tots els esports: "+consulta.list().size());
		
		for (Sports result : results) {
			System.out.println(result.getCod() + ": " + result.getName());
					
		}
	}

	public static void mostraAthletes() {
		Query<Athletes> consulta =  session.createQuery("from athletes", Athletes.class);
		//Query<Sports> consulta =  session.createQuery();
		java.util.List<Athletes> results = consulta.list();
		System.out.println("Mostrant tots els esports: "+consulta.list().size());
		
		for (Athletes result : results) {
			System.out.println(result.getCod() +
					": " + result.getName() + " -> "+ result.getSport().getCod()+" -- "+ result.getSport().getName()+" -- "+result.getSport());
					
		}
	}

	// 	public static void nativeQuery() {
	// 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	// 	Session session = sessionFactory.openSession();
	// 	List<Sports> sports = (List<Sports>) session.createNativeQuery(
	// 			"SELECT * FROM sports")
	// 			.addEntity(Sports.class)
	// 			.list();
	// 	for (Sports sport : sports) {
	// 		System.out.println(sport.getName());
	// 	}
	// 	session.close();
	// }

	public static void main(String[] args) {
		

		System.out.println("Connecting...");
		 tearUp();
		 System.out.println("Connected!!...");

		 comprobarSesion();
		 //nativeQuery();
		mostraSports();
		 mostraAthletes();
		tearDown();
	}
}
