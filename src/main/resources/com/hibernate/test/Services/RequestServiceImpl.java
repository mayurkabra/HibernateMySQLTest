package com.hibernate.test.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.test.DAO.RideDAOImpl;
import com.hibernate.test.api.RequestDAOInterface;
import com.hibernate.test.pojo.Request;
<<<<<<< HEAD
import com.hibernate.test.pojo.RequestRideMapping;
import com.hibernate.test.pojo.RequestRideStatus;
=======
>>>>>>> refs/remotes/origin/master
import com.hibernate.test.pojo.Ride;
import com.hibernate.test.pojo.User;

@Service
@Transactional
public class RequestServiceImpl implements com.hibernate.test.api.RequestServiceInterface {
	
	@Autowired
	RequestDAOInterface requestDAO;
	@Autowired
	RideDAOImpl rideDAO;

	public void createRequest(Request newRequest) {
		requestDAO.createRequest(newRequest);
	}

	public void respondToRequest() {
		// TODO Auto-generated method stub
		
	}

	public void cancelRequest(long requestId) {
		// TODO Auto-generated method stub
		
	}

	public void editRequest(Request updatedRequest) {
		// TODO Auto-generated method stub
		
	}
	
	public Request fetchRequest(Long requestId) {
		return requestDAO.fetchRequest(requestId);
		
	@Override
	public List<Request> getAllRequests() {
		return requestDAO.getAllRequests();
	}
	
	@Override
	public List<Request> getAllRequestsForAUser(User requestedBy){
		return requestDAO.getAllRequestsForAUser(requestedBy);
	}
	
	@Override
	public void createNewRequestRideMapping(Request request, Ride ride){
		requestDAO.createNewRequestRideMapping(request, ride);
	}

	@Override
	public boolean isRideCompletelyFull(Ride ride) {
		return requestDAO.isRideCompletelyFull(ride);
	}

	@Override
	public boolean isRideForRequestFixed(Request request) {
		return requestDAO.isRideForRequestFixed(request);
	}

	@Override
	public boolean isMappingExistingForRequestRideMap(Request request, Ride ride) {
		return requestDAO.isMappingExistingForRequestRideMap(request, ride);
	}

	public List<Request> getAllRequests() {
		return requestDAO.getAllRequests();
	}
	
	public List<Request> getAllRequestsForAUser(User requestedBy){
		return requestDAO.getAllRequestsForAUser(requestedBy);
	}
	
	public void createNewRequestRideMapping(Request request, Ride ride){
		requestDAO.createNewRequestRideMapping(request, ride);
	}

	public boolean isRideCompletelyFull(Ride ride) {
		return requestDAO.isRideCompletelyFull(ride);
	}

	public boolean isRideForRequestFixed(Request request) {
		return requestDAO.isRideForRequestFixed(request);
	}

	public boolean isMappingExistingForRequestRideMap(Request request, Ride ride) {
		return requestDAO.isMappingExistingForRequestRideMap(request, ride);
	}
	
	public List<Request> getAllRequestsFilteredOnDateAndUser(Long rideId){
		Ride ride = rideDAO.fetchRide(rideId);
		return requestDAO.getAllRequestsFilteredOnDateAndUser(ride);
	}

	public int createRequestRideMapping(Long[] selectedRequestIds, Long rideId){
		int countOfMapping=0;
		Ride ride = rideDAO.fetchRide(rideId);
		for(int i=0; i<selectedRequestIds.length ;i++){
			Request request = fetchRequest(selectedRequestIds[i]);
			if(requestDAO.createNewRequestRideMapping(request, ride)){
				countOfMapping++;
			}
		}
		if(countOfMapping == selectedRequestIds.length){
			return 1;
		}
		else if((countOfMapping < selectedRequestIds.length) && (countOfMapping > 0)){
			return 0;
		}
		else {
			return -1;
		}
	}
}
