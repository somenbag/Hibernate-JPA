package org.jsp.hibernate_demo;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
public class FetchEmployee 
{
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter your id to display the details ");
	int id=sc.nextInt();
	Session s= new Configuration().configure().buildSessionFactory().openSession();
	Employee e =s.get(Employee.class, id);
	if(e!=null) {
		System.out.println("id:"+e.getId());
		System.out.println("name:"+e.getName());
		System.out.println("designation:"+e.getDesg());
		System.out.println("salary:"+e.getSalary());
	}
	else
	{
		System.err.println("you have entered an invalid id");
	}
}
}
