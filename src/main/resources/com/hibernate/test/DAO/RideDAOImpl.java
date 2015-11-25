package com.hibernate.test.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hibernate.test.api.RideDAOInterface;
import com.hibernate.test.pojo.RequestRideMapping;
import com.hibernate.test.pojo.Ride;
import com.hibernate.test.util.HibernateUtil;

@Repository
public class RideDAOImpl implements RideDAOInterface {
	
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
	
	/*public void deleteRide(Ride rideToDelete)
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
	}*/
	
	public void deleteRide(long rideId)
	{
		List<RequestRideMapping> result = fetchAllRequestRideMappings(rideId);
		if(result != null){
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			try
			{
				for(RequestRideMapping mappingObj : result){
					session.delete(mappingObj);
				}
				session.getTransaction().commit();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			session.close();
		}
	}
	
	public List<RequestRideMapping> fetchAllRequestRideMappings(long rideId)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try
		{
			Criteria criteria = session.createCriteria(RequestRideMapping.class);
			criteria.createAlias("ride", "ride");
			criteria.add(Restrictions.eq("ride.rideId",rideId));
			
			List<RequestRideMapping> result = criteria.list();
			if(result.isEmpty())
				return null;
			session.close();
			return result;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.close();
			return null;
		}
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
	
	public List<Ride> fetchUserRides(int userId){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		try
		{
			Criteria criteria = session.createCriteria(Ride.class);
			criteria.createAlias("rideOwner", "user"); 
			criteria.add(Restrictions.eq("user.userId", userId));
			List<Ride> userRideList = criteria.list();
			if(userRideList.isEmpty())
				return null;
			session.close();
			return userRideList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.close();
			return null;
		}
	}
	
	public void addRequestToRide(RequestRideMapping mappingObj){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try
		{
			session.save(mappingObj);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		session.close();
	}
}
