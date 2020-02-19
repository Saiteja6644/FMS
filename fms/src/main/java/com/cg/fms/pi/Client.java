package com.cg.fms.pi;

import java.util.List;
import java.util.Scanner;

import com.cg.fms.bean.User;
import com.cg.fms.exception.FlightException;
import com.cg.fms.service.UserService;
import com.cg.fms.service.UserServiceImpl;

public class Client
{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        UserService userService=new UserServiceImpl();
        int choice=0;
        User user=null;
        List<User> userList=null;
     while(choice!=6)
     {   
    	System.out.println("AdminType"); 
    	System.out.println("1.Add User");
    	System.out.println("2.view usert");
    	System.out.println("3.View list of user");
    	System.out.println("4.update user");
    	System.out.println("5.delete user");
    	System.out.println("6.Exist");
    	System.out.println("Enter your choice");
    	choice = sc.nextInt();
    	sc.nextLine();
    	if(choice==1)
    	{
    	switch(choice)
    	{
    	case 1 : System.out.println("Enter userName");
    			 String name = sc.nextLine();
    			 //sc.nextLine();
    			 System.out.println("Enter password");
    			 String password = sc.nextLine();
    			 System.out.println("Enter userPhone");
    			 int userPhone = sc.nextInt();
    			 System.out.println("Enter email");
    			 String email = sc.nextLine();
    			 sc.nextLine();
    			 user = new User();
    			 user.setUserName(name);
    			 user.setPassword(password);
    			 user.setUserPhone(userPhone);
    			 user.setUserEmail(email);
    			 try
    			 {
    				User u ; 
    				 u = userService.addUser(user);
    				int id = u.getUserId();
    				System.out.println(" Added successfully " +id );
    			 }
    			 catch(FlightException e)
    			 {
    				 System.err.println(e.getMessage());
    			 }
    			 
    	case 2 : System.out.println("Enter userId");
    	         
    			 
    	}
    	

}
	}
}
}
