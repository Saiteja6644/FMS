package com.cg.fms.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.fms.bean.User;
import com.cg.fms.exception.FlightException;

public class UserDaoImpl implements UserDao {

	private List<User> list;
	private Map<Integer,User> map;
	
	public UserDaoImpl(List<User> list, Map<Integer,User> map)
	{
		list = new ArrayList<User>();
		map = new HashMap<>();
	}
	

	
	@Override
	public User addUser(User user) throws FlightException   {
		
		boolean flag = list.contains(user.getUserId());
		if(flag)
		{
			throw new FlightException("Id already exists");
	}
	
	list.add(user);
	
		return user;
	}

	@Override
	public User viewUser(int userId) throws FlightException {
		
	User user = null;
	if(!list.contains(userId))	
	{
		throw new FlightException("Id not found");
	}
		
	
	user = map.get(userId);
		
	  return user;
	}
	@Override
	public List<User> viewUser() {
		Collection<User> col =map.values();
		List<User> list = new ArrayList<>(col);
		
		
		
		return list;
	}

	@Override
	public User updateUser(User user) 
	{
		
		
		
		return null;
	}

	@Override
	public void deleteUser(int userId) {
		
		int index = list.indexOf(userId);
		list.remove(index);
		
	}

	
}
