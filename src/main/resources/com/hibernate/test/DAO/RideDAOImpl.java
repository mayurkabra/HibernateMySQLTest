package com.hibernate.test.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.hibernate.test.api.RideDAOInterface;
import com.hibernate.test.pojo.Ride;
import com.hibernate.test.util.HibernateUtil;

public class RideDAOImpl implements RideDAOInterface {
	private static RideDAOInterface rideDAOImpl;
	
	public void createRide(Ride newRide)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try
		{
			session.save(newRide);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		session.close();
	}
	
	public void editRide(Ride updatedRide)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try
		{
			session.saveOrUpdate(updatedRide);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		session.close();
	}
	
	public void deleteRide(Ride rideToDelete)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try
		{
			session.delete(rideToDelete);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		session.close();
	}
	
	public Ride fetchRide(long rideId)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		try
		{
			Criteria criteria = session.createCriteria(Ride.class);
			criteria.add(Restrictions.eq("rideId",rideId));
			
			List<Ride> result = criteria.list();
			if(result.isEmpty())
				return null;
			session.close();
			return result.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.close();
			return null;
		}
	}
	
	public static RideDAOInterface getRideDAOImpl()
	{
		if(rideDAOImpl==null)
		{
			rideDAOImpl = new RideDAOImpl();
		}
		
		return rideDAOImpl;
	}
}
