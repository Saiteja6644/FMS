package com.cg.fms.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.fms.bean.User;
import com.cg.fms.dao.UserDao;
import com.cg.fms.dao.UserDaoImpl;
import com.cg.fms.exception.FlightException;

class TestFms {

	UserDao dao =null;
	
	private User user=null;
	
   @BeforeEach
     void  setUp()
     {
	   dao = new UserDaoImpl();
	}
	
   @Test
   void testAddUser() throws FlightException
   {
	  
	   User user =new User("Admin",1001,"Sai","saiteja",632541,"sai@gmail.com");

	   User u=dao.addUser(user);

	    assertEquals("Sai",u.getUserName());
	  }
   
   
   
   
    @Test
    void testViewUser() throws Exception
    {
    	 User user =new User("Admin",1001,"Sai","saiteja",632541,"sai@gmail.com");

  	      dao.addUser(user);
  	     
    	List<User> list = dao.viewUser();
    	assertEquals(1,list.size());
    	
    }
    
    
    

}
