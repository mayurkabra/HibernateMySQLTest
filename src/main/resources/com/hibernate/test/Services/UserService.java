package com.hibernate.test.Services;

import com.hibernate.test.DAO.UserDAOImpl;
import com.hibernate.test.api.UserDAOInterface;
import com.hibernate.test.pojo.User;

public class UserService implements UserServiceInterface {
	public User authenticate(String username, String password)
	{
		try
		{
			//input validation
			//if valid input - create a DAO object
			UserDAOInterface userDao = UserDAOImpl.getUserDAOImpl();
			return userDao.getUserInfo(username, password);

		}
		catch(Exception e)
		{
			e.printStackTrace()
		}
	}
}
