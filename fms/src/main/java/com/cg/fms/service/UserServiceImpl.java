package com.cg.fms.service;


import java.util.List;
import java.util.Random;

import com.cg.fms.bean.User;
import com.cg.fms.dao.UserDao;
import com.cg.fms.dao.UserDaoImpl;
import com.cg.fms.exception.FlightException;

public class UserServiceImpl implements  UserService{

	private UserDao userDao;
	public UserServiceImpl()
	{
		userDao = new UserDaoImpl();
	}
	
	
	public boolean validateUser(User user) throws FlightException
	{
		String mail = user.getUserEmail();
		String password = user.getPassword();
		if(mail.matches("^[a-zA-z0-9+_.-]+@(.+)$") || password.matches("[a-zA-Z0-9]+"))
			return true;
		else
			throw new FlightException("Invalid input");   
	}
	
	
	@Override
	public User addUser(User user) throws FlightException {
		if(validateUser(user))
		{
		String name = user.getUserName();
		if(name.matches("[a-zA-Z]+"))
		{
			Random rand = new Random();
			int id = rand.nextInt(100)+1000;
			user.setUserId(id);
		}
		else
		{
			throw new FlightException(" Name should be characters");
		}
		}
		return userDao.addUser(user);
	}

	@Override
	public User viewUser(int userId) throws FlightException{
		
		String str = String.valueOf(userId);
		if(!str.matches("[0-9]{4}"))
		{
			throw new FlightException(" Id is not valid");
		}
		return userDao.viewUser(userId);
	}

	@Override
	public List<User> viewUser() throws FlightException {
	
			return userDao.viewUser();
	}

	@Override
	public User updateUser(User user , String userName) throws FlightException{
		
		return userDao.updateUser(user, userName);
	}

	@Override
	public void deleteUser(int userId) throws FlightException{
		
		userDao.deleteUser(userId);
	
	}

}
