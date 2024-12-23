package castellet.dam.m12.uf2.hibernate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class ViewClass {
	Scanner terminalInput = null;
	int code = 0;
	String cod = null;
	String cod2 = null;
	String name = null;
	Session session;
	
	
	public ViewClass(Session session) {
		super();
		this.session = session;
	}


	//Deportes sport = null;
	//PostgreDeportesDAO sportDAO = null;
	//PostgreDeportistasDAO ahtletestDAO = null;
	//PostgreDeportistasDAO ahtletestDAO = null;




	@SuppressWarnings("deprecation")
	public void SportForm() {
		// TODO Auto-generated method stub
		terminalInput = new Scanner(System.in);
		System.out.println("Enter the name of the sport:");
		name = terminalInput.nextLine();
		System.out.println("Enter the code of the sport:");
		cod = terminalInput.nextLine();
		
		Sports sport = new Sports();
		sport.setName(name);
		sport.setCod(cod);
		session.beginTransaction();
		session.persist(sport);

		session.getTransaction().commit();
		//session.close();
		//session.getTransaction().commit();
		
		//sportDAO = new PostgreDeportesDAO(connection);
		//sportDAO.insertar(sport);
		
	}


public void SportsList()
	{
	Query<Sports> consulta =  session.createQuery("from sports", Sports.class);
	//Query<Sports> consulta =  session.createQuery();
	java.util.List<Sports> results = consulta.list();
	System.out.println("Mostrant tots els esports: "+consulta.list().size());
	
	for (Sports result : results) {
		System.out.println(result.getCod() + ": " + result.getName());
				
	}
	}


	public void AthleteForm() {
		terminalInput = new Scanner(System.in);
		System.out.println("Enter the name of the new Athlete:");
		name = terminalInput.nextLine();
		System.out.println("Enter the cod of the new Athlete:");
		cod2 = terminalInput.nextLine();
		System.out.println("Enter the sports CODE for this ahtlete:");
		SportsList();
		cod = terminalInput.nextLine();
		Athletes ahtletes = new Athletes();
		Sports sport = (Sports) session.load(Sports.class, cod);
		ahtletes.setName(name);
		ahtletes.setSport(sport);
		ahtletes.setCod(cod2);
		session.beginTransaction();
		session.persist(ahtletes);
		session.getTransaction().commit();
		//ahtletes.setSport();
		//ahtletestDAO = new PostgreDeportistasDAO(connection);
		//ahtletestDAO.insertar(ahtletes);
		
		
	}


	public void searchAhtlete() {
		// TODO Auto-generated method stub
		terminalInput = new Scanner(System.in);
		System.out.println("Enter the name of the Athlete to search:");
		name = terminalInput.nextLine();
		//String name2 = "'%"+name.toLowerCase()+"%'";
		Query<Athletes> consulta =  session.createQuery("from athletes d where LOWER (d.name) like :patro", Athletes.class).setParameter("patro", "%"+name.toLowerCase()+"%");
		//Query<Sports> consulta =  session.createQuery();
		java.util.List<Athletes> results = consulta.list();
		System.out.println("Mostrant els atletes: "+consulta.list().size());
		
		for (Athletes result : results) {
			System.out.println(result.getCod() +
					": " + result.getName() + " -> "+ result.getSport().getCod()+" -- "+ result.getSport().getName()+" -- "+result.getSport());
					
		}
	}


	public void AthleteList() {
		//Session session2 = session.getFactory().openSession();
		Query<Sports> consultaSports =  session.createQuery("from sports", Sports.class);
		//Query<Athletes> consultaAthletes;
		Set<Athletes>  resultsAthletes;
		//Query<Sports> consulta =  session.createQuery();
		
		java.util.List<Sports> resultsSports = consultaSports.list();
		
		System.out.println("Mostrant tots els esports: "+consultaSports.list().size());
		
		for (Sports result : resultsSports) {
			System.out.println(result.getCod() + ": " + result.getName());
			
			//consultaAthletes =  session2.createQuery("from athletes", Athletes.class);
			//resultsAthletes = consultaAthletes.list();
			resultsAthletes = result.getAthletes();
			System.out.println("Mostrant tots els atletes: ");
			for (Athletes result2 : resultsAthletes) {
				if (result2.getSport().getCod().equals(result.getCod()))
				{
					System.out.println(result2.getCod() +
							": " + result2.getName() + " -> "+ result2.getSport().getCod()+" -- "+ result2.getSport().getName()+" -- "+result2.getSport());	
				}
				
						
			}
					
		}
		
		
	}

}
