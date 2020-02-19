package com.cg.fms.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cg.fms.bean.User;
import com.cg.fms.exception.FlightException;

public class UserDaoImpl implements UserDao {

	private List<User> userList;
	//private Map<Integer,User> map;
	
	public UserDaoImpl()
	{
		userList = new ArrayList<User>();
	}
	

	
	@Override
	public User addUser(User user) throws FlightException   {
		
	 boolean flag = userList.stream().anyMatch(p-> p.getUserId()==user.getUserId());
	 if(flag==true)
	 {
		 throw new FlightException("Id already exists");
	 }
	 userList.add(user);
	 return user;
	}

	@Override
	public User viewUser(int userId) throws FlightException {
		
	User user = null;

	boolean flag = userList.stream().anyMatch(p-> p.getUserId()==userId);
	if(!flag)
	{
		throw new FlightException(" Id not found");
	}
	user = userList.get(userId);
	return user;
	  
	}
	@Override
	public List<User> viewUser() {
		
		List<User> list = userList.stream().collect(Collectors.toList());
		return list;
	}

	@Override
	public User updateUser(User user) throws FlightException 
	{
		
		boolean flag = userList.stream().anyMatch(p-> p.getUserId()==user.getUserId());
		if(flag==true)
		{
			user.setUserId(user.getUserId());
		}
		else
		{
			throw new FlightException("Id not found");
		}
		return user;
	}

	@Override
	public void deleteUser(int userId) throws FlightException{
		
		//boolean flag = userList.stream().allMatch(p-> p.getUserId()==userId);
		boolean flag = userList.stream().anyMatch(p-> p.getUserId()==userId);
		if(!flag)
		{
			throw new FlightException(" Id not found");
		}
		userList.remove(userId);
	
		
	}

	
}
