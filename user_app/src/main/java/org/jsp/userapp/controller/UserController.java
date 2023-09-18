package org.jsp.userapp.controller;

import java.util.Scanner;
import org.jsp.userapp.dao.UserDao;
import org.jsp.userapp.dto.User;
public class UserController
{
static Scanner s=new Scanner(System.in);
static UserDao dao=new UserDao();
public static void main(String[] args) 
{
	System.out.println("1.Register");
	System.out.println("2.Edit Your Details");
	System.out.println("3.Find User By Id");
	System.out.println("4.Delete User By Id");
	System.out.println("5.Verify User By Phone And Password");
	System.out.println("6.Verify Users By Email And Password");
	System.out.println("7.Verify Users By Id And Password");
	int choice = s.nextInt();
	switch (choice) 
	{
	case 1:{
		save();
		break;
	}
	
	case 2:{
		update();
		break;
	}
	case 3:{
		findUserById();
		break;
	}
	case 4:{
		deleteUser();
		break;
	}
	case 5:
	{
		VerifyUserByPhoneAndPassword();
		break;
	}
	case 6:{
		VerifyUsersByEmailAndPassword();
		break;
	}
	case 7:{
		VerifyUsersByIdAndPassword();
		break;
	}
}
}
public static void save()
{
	System.out.println("Enter your Name,Email,Gender,Phone,Password to register");
	String name=s.next();
	String email=s.next();
	String gender=s.next();
	long phone =s.nextLong();
	String password=s.next();
	User u = new User();
	u.setName(name);
	u.setEmail(email);
	u.setGender(gender);
	u.setPhone(phone);
	u.setPassword(password);
	u=dao.saveUser(u);
	System.out.println("You are register with Id:"+u);
}
public static void update()
{   
	System.out.println("Enter Your Id");
	int id=s.nextInt();
	System.out.println("Enter your Name,Email,Gender,Phone,Password to register");
	String name=s.next();
	String email=s.next();
	String gender=s.next();
	long phone =s.nextLong();
	String password=s.next();
	User u = new User();
	u.setId(id);
	u.setName(name);
	u.setEmail(email);
	u.setGender(gender);
	u.setPhone(phone);
	u.setPassword(password);
	u=dao.updateUser(u);
	System.out.println("You account is update :");
	
}
public static void findUserById()
{   
	System.out.println("Enter Your Id to find details");
	int id=s.nextInt();
	User u = new User();
	u=dao.findUserById(id);
	System.out.println(u);
	System.out.println("your id");


}
public static void deleteUser()
{   
	System.out.println("Enter Your Id to delete the record");
	int id=s.nextInt();
	Object u = new User();
	u=dao.deleteUser(id);
	System.out.println(u);
	System.out.println(" record delete successfully"+id);
	}
public static void VerifyUserByPhoneAndPassword()
{   
	System.out.println("Enter Your Phone And Password");
	long phone=s.nextLong();
    String password=s.next();
	User u = new User();
	u=dao.verifyUser(phone, password);
	System.out.println(u);
	System.out.println("  successfully login "+phone);
	}
public static void VerifyUsersByEmailAndPassword()
{   
	System.out.println("Enter Your Email And Password");
	 String email=s.next();
	 String password=s.next();
	User u = new User();
	u=dao.verifyUser(email, password);
	System.out.println(u);
	System.out.println(" login successfully"+email);
	}
public static void VerifyUsersByIdAndPassword()
{   
	System.out.println("Enter Your Id And Password");
	int id=s.nextInt();
	 String password=s.next();
	User u = new User();
	u=dao.verifyUser(id,password);
	System.out.println(u);
	System.out.println(" login successfully"+id);
	}}
  