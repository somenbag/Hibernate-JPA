package org.jsp.compositekey.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsp.compositekey.dto.Person;
import org.jsp.compositekey.dto.PersonId;
public class FetchPersonByPhoneAndEmail 
{
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter your phone and email");
	long phone=s.nextLong();
	String email=s.next();
	PersonId pid=new PersonId();
	pid.setEmail(email);
	pid.setPhone(phone);
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	
	Person p=manager.find(Person.class,pid);
	if(p!=null) {
		System.out.println("Name:"+p.getName());
		System.out.println("Age:"+p.getAge());
		System.out.println("Phone number:"+p.getId().getPhone());
		System.out.println("Email id:"+p.getId().getEmail());
	}
	else {
		System.err.println("you have enter invalid phone and email id");
	}
}
}
