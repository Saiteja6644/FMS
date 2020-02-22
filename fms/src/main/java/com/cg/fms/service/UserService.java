package com.cg.fms.service;

import java.util.List;

import com.cg.fms.bean.User;
import com.cg.fms.exception.FlightException;

public interface UserService {
	
	public  User addUser(User user) throws FlightException; 
	public User viewUser(int userId) throws FlightException;
	public List<User> viewUser() throws FlightException;
	public User updateUser(User user, String userName) throws FlightException;
	public  void deleteUser(int userId) throws FlightException;

}
