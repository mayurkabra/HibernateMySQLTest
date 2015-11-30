package com.hibernate.test.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.test.DAO.UserDAOImpl;
import com.hibernate.test.api.UserDAOInterface;
import com.hibernate.test.api.UserServiceInterface;
import com.hibernate.test.pojo.User;

@Service
public class UserService implements UserServiceInterface {
	
	@Autowired
	UserDAOInterface userDao;
	
	public User authenticate(String username, String password)
	{
		try
		{
			//input validation
			//if valid input - create a DAO object
			//UserDAOInterface userDao = UserDAOImpl.getUserDAOImpl();
			return userDao.getUserInfo(username, password);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createUser(User newUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User authenticateUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editProfile(User newUser) {
		// TODO Auto-generated method stub
		
	}
}
