package com.hibernate.test.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hibernate.test.api.RequestDAOInterface;
import com.hibernate.test.pojo.Request;
import com.hibernate.test.util.HibernateUtil;

@Repository
public class RequestDAOImpl implements RequestDAOInterface {
	
	public void createRequest(Request newRequest)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try
		{
			session.save(newRequest);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		session.close();
	}
	
	public void editRequest(Request updatedRequest)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try
		{
			session.saveOrUpdate(updatedRequest);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		session.close();
	}
	
	public void deleteRequest(Request requestToDelete)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try
		{
			session.delete(requestToDelete);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		session.close();
	}
	
	public Request fetchRequest(long RequestId)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		try
		{
			Criteria criteria = session.createCriteria(Request.class);
			criteria.add(Restrictions.eq("RequestId",RequestId));
			
			List<Request> result = criteria.list();
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
	
}
