package org.jsp.controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.dto.Person;

public class VerifyPerson 
{
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter your phone number and password");
	long phone=s.nextLong();
	String password=s.next();
	String qry="select p from Person p where p.phone=?1 and p.password=?2";
    EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
    Query q=manager.createQuery(qry);
    q.setParameter(1,phone);
    q.setParameter(2,password);
    try
    {
    	Person p=(Person)q.getSingleResult();
    	System.out.println("hello mr "+p.getName()+"your login is successfully");
    	System.out.println(p);
    }
    catch (NoResultException e) {
System.out.println("invalid phone and password");
    }
}
}