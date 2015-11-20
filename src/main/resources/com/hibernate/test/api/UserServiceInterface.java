package com.hibernate.test.api;

public interface UserServiceInterface {

	//This method will create a new user in the system
	//@param User object with all user details
	public void createUser(User newUser);
	
	//This method will check whether the user is a valid one or not
	//@param username and password of the user
	//@return true if valid else false
	public boolean authenticateUser(String username, String password);
	
	//This method allows you to edit information for an existing user
	//@param User object with updated user information
	public void editProfile(User newUser);
}
