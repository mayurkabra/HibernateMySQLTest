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

	@Override
	public void createRequest(Request newRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void respondToRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelRequest(long requestId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editRequest(Request updatedRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Request> getAllRequests() {
		// TODO Auto-generated method stub
		return null;
	}

}
