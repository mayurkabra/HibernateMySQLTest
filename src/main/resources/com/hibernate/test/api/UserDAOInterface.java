package com.hibernate.test.api;

import com.hibernate.test.pojo.User;

public interface UserDAOInterface {
	public User getUserInfo(String username, String password);
	public void createUser(User newUser);
	public void editProfile(User user);
	public User findByUserName(String username);
}