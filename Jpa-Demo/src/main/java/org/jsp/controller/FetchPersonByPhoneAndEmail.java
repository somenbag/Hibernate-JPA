package org.jsp.controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.dto.Person;

public class FetchPersonByPhoneAndEmail
{
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter your phone no And email");
	long phone=s.nextLong();
	String email=s.next();
	String qry="select p from Person p where p.phone=?1 and p.password=?2";
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	Query q=manager.createQuery(qry);
	q.setParameter(1,phone);
	q.setParameter(2,email);
	try
	{
		Person p=(Person)q.getSingleResult();
		System.out.println("your email id is"+p.getEmail()+"your login is  succeefully");
		System.out.println("p");
	}
	catch (NoResultException e) {

	System.out.println("Invalid phone and email");
	}
}
}
