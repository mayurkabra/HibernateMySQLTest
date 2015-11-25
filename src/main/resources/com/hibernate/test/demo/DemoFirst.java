package com.hibernate.test.demo;

import java.util.Date;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.hibernate.test.pojo.Request;
import com.hibernate.test.pojo.RequestRideMapping;
import com.hibernate.test.pojo.Ride;
import com.hibernate.test.pojo.Student;
import com.hibernate.test.util.HibernateUtil;  


public class DemoFirst {  

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
		Session session = sessionFactory.openSession();  
		session.beginTransaction();  

		try {
			Student student = new Student();  
			student.setFirstName("Stro");  
			student.setAge(26);  

			session.save(student);  
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		session.close();  

	}  

	@Test
	public void saveARequest(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
		Session session = sessionFactory.openSession();  
		session.beginTransaction(); 
		
		Request request = new Request();
		request.setDestination("TD");
		request.setPickupPlace("PP");
		request.setRequestTime(new Date());
		
		session.save(request);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void saveARide(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
		Session session = sessionFactory.openSession();  
		session.beginTransaction(); 
		
		Ride ride = new Ride();
		ride.setStartPoint("SP");
		ride.setDestination("D");
		
		session.save(ride);
		session.getTransaction().commit();
		session.close();
	}
	
	public void saveRRMapping(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
		Session session = sessionFactory.openSession();  
		session.beginTransaction(); 
		
		RequestRideMapping mapping = new RequestRideMapping();
		
		session.save(mapping);
		session.getTransaction().commit();
		session.close();
	}
}  