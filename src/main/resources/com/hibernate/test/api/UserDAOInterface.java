package com.hibernate.test.api;

import com.hibernate.test.pojo.User;

public interface UserDAOInterface {
	public User getUserInfo();
	public User enterNewUser();
	public User editUser();
}
