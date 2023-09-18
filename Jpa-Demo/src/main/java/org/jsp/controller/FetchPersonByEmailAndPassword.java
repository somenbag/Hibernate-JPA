package org.jsp.controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.dto.Person;

public class FetchPersonByEmailAndPassword 
{
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter your Email id and password");
	String email=s.next();
	String password=s.next();
	String qry="select p from Person p where p.email=?1 and  p.password=?2";
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	Query q=manager.createQuery(qry);
	q.setParameter(1, email);
	q.setParameter(2,password);
	try
	{
		Person p=(Person)q.getSingleResult();
		System.out.println(p.getEmail());
		System.out.println(p);
	}
	catch(NoResultException e)
	{
	System.err.println("invalid email id and password");	
	}
	
}
}
