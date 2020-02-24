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
    	System.out.println("2.view user");
    	System.out.println("3.View list of user");
    	System.out.println("4.update user");
    	System.out.println("5.delete user");
    	System.out.println("6.Exist");
    	System.out.println("Enter your choice");
    	try
    	{
    	choice = sc.nextInt();
    	sc.nextLine();
    	}
    	catch(Exception e)
    	{
    		System.err.println("Enter valid choice");
    		sc.nextLine();
    	}
    	switch(choice)
    	{
    	case 1 :   
    			 System.out.println("Enter userName");
    			 String name = sc.nextLine();
    			 //sc.nextLine();
    			 System.out.println("Enter password");
    			 String password = sc.nextLine();
    			 System.out.println("Enter userPhone");
    			 long userPhone = sc.nextLong();
    			 sc.nextLine();
    			 System.out.println("Enter email");
    			 String email = sc.nextLine();
    			 user = new User();
    			 user.setUserName(name);
    			 user.setPassword(password);
    			 user.setUserPhone(userPhone);
    			 user.setUserEmail(email);
    			 try
    			 {
    				User user1 ; 
    				 user1 = userService.addUser(user);
    				int id = user1.getUserId();
    				System.out.println(" Added successfully " +id );
    			 }
    			 catch(FlightException e)
    			 {
    				 System.err.println(e.getMessage());
    			 }
    			 break;
    			 
    	case 2 : 
    			 try
    			 {
    			 System.out.println("Enter userId to view");    			
    				 int id = sc.nextInt();
    				user= userService.viewUser(id);
    				System.out.println("id= "+user.getUserId()+" userName = "+user.getUserName()+" userPassword= "+user.getPassword()+" userEmail= "+user.getUserEmail()+" userPhone = "+user.getUserPhone());
    			 }
    			 catch(FlightException e)
    			 {
    				 System.err.println(e.getMessage());
    			 }
    			 break;
    	case 3 : 
    			try 
    			{
    			  userList =userService.viewUser();
    			  for(User u : userList )
    			  {
    				  int id = u.getUserId();
    				  String userName = u.getUserName();
    				  double phone = u.getUserPhone();
    				  String mail = u.getUserEmail();
    				  System.out.println("id= "+id+" userName = "+userName+" userPhone= "+phone+" userEmail= "+mail);
    			  }
    			}
    			catch(FlightException e)
    			{
    				System.err.println(e.getMessage());
    			}
    			break;
    	     
    	case 4 : System.out.println("Enter the id ");
    			 int newId = sc.nextInt(); 
    			 sc.nextLine();
    			 System.out.println("Enter the name to be updated");
    			 String newName = sc.nextLine();
    			 try
    			 {
    			user =	 userService.updateUser(user, newName);
    			System.out.println("updated successfuly");
    			 }
    			 catch(FlightException e)
    			 {
    				 System.err.println(e.getMessage());
    			 }
    			 break;
    	case 5 : System.out.println("Enter the id to be deleted");
    	         int id = sc.nextInt();
    	         try
    	         {
    	        	 userService.deleteUser(id);
    	        	 System.out.println("deleted successfully");
    	         }
    	         catch(FlightException e)
    	         {
    	        	 System.err.println(e.getMessage());
    	         }
    	         break;
    	case 6 : System.out.println("Thank You");
    	          return;
    	}
    	

}
	}
}

