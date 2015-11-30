package com.hibernate.test.api;

import java.util.List;

import com.hibernate.test.pojo.Request;

public interface RequestDAOInterface {

	public void createRequest(Request newRequest);
	public void editRequest(Request updatedRequest);
	public void deleteRequest(Request RequestToDelete);
	public Request fetchRequest(long RequestId);
	public List<Request> getAllRequests();
}
