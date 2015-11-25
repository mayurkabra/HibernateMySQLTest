package com.hibernate.test.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.test.api.RequestDAOInterface;
import com.hibernate.test.pojo.Request;

@Service
public class RequestServiceImpl implements com.hibernate.test.api.RequestServiceInterface {
	
	@Autowired
	RequestDAOInterface requestDAO;

	public void createRequest(Request newRequest) {
		// TODO Auto-generated method stub
		
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

	public List<Request> getAllRequests() {
		// TODO Auto-generated method stub
		return null;
	}

}
