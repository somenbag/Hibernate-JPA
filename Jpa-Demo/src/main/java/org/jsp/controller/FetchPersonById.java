package org.jsp.controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsp.dto.Person;

public class FetchPersonById 
{
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter your id to display details");
	int id=s.nextInt();
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	Person p=manager.find(Person.class, id);
	if(p!=null) {
		System.out.println("id:"+p.getId());
		System.out.println("name:"+p.getName());
		System.out.println("Age:"+p.getAge());
		System.out.println("phone:"+p.getPhone());
		System.out.println("Email:"+p.getEmail());
	}
	else
	{
		System.out.println("you have enter invalid id");
	}
}
}
