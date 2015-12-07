package com.hibernate.test.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.hibernate.test.api.RequestDAOInterface;
import com.hibernate.test.pojo.Request;
import com.hibernate.test.pojo.RequestRideMapping;
import com.hibernate.test.pojo.RequestRideStatus;
import com.hibernate.test.pojo.Ride;
import com.hibernate.test.pojo.User;
import com.hibernate.test.util.HibernateUtil;

@Repository
public class RequestDAOImpl extends CustomHibernateDaoSupport implements RequestDAOInterface {
	
	@Override
	public void createRequest(Request newRequest)
	{
		/*SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
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
		session.close();*/
		/*SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(newRequest);*/
		try {
			getHibernateTemplate().save(newRequest);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void editRequest(Request updatedRequest)
	{
		/*SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
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
		session.close();*/
		try {
			getHibernateTemplate().saveOrUpdate(updatedRequest);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteRequest(Request requestToDelete)
	{
		/*SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
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
		session.close();*/
	}
	
	@Override
	public Request fetchRequest(long RequestId)
	{
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		/*SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();*/
		
		try
		{
			Criteria criteria = session.createCriteria(Request.class);
			criteria.add(Restrictions.eq("request_id",RequestId));
			
			List<Request> result = criteria.list();
			if(result.isEmpty())
				return null;
			return result.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Request> getAllRequests() {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Request.class);
		return criteria.list();
	}

	@Override
	public List<Request> getAllRequestsForAUser(User requestedBy) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Request.class);
		criteria.add(Restrictions.eq("requestedBy", requestedBy));
		return criteria.list();
	}
	
	@Override
	public void createNewRequestRideMapping(Request request, Ride ride){
		if(!this.isMappingExistingForRequestRideMap(request, ride) &&
				!this.isRideCompletelyFull(ride) &&
				!this.isRideForRequestFixed(request)){
			Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			RequestRideMapping requestRideMapping = new RequestRideMapping();
			requestRideMapping.setRequest(request);
			requestRideMapping.setRide(ride);
			requestRideMapping.setRequestRideStatus(RequestRideStatus.PENDING);
			session.save(requestRideMapping);
		}
	}
	
	@Override
	public boolean isMappingExistingForRequestRideMap(Request request, Ride ride){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(RequestRideMapping.class);
		criteria.add(Restrictions.eq("request", request));
		criteria.add(Restrictions.eq("ride", ride));
		criteria.setProjection(Projections.rowCount());
		int count = (int) criteria.uniqueResult();
		if (count!=0){
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean isRideForRequestFixed(Request request){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(RequestRideMapping.class);
		criteria.add(Restrictions.eq("request", request));
		criteria.add(Restrictions.eq("requestRideStatus", RequestRideStatus.ACCEPTED));
		criteria.setProjection(Projections.rowCount());
		int count = (int) criteria.uniqueResult();
		if (count!=0){
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean isRideCompletelyFull(Ride ride){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(RequestRideMapping.class);
		criteria.add(Restrictions.eq("ride", ride));
		criteria.add(Restrictions.eq("requestRideStatus", RequestRideStatus.ACCEPTED));
		criteria.setProjection(Projections.rowCount());
		int count = (int) criteria.uniqueResult();
		if (ride.getMaxNoOfPassengers()>=count){
			return true;
		} else {
			return false;
		}
	}
	
}
