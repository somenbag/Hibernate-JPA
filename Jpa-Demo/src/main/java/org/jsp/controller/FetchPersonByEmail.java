package org.jsp.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.dto.Person;

public class FetchPersonByEmail 
{
 public static void main(String[] args) 
 {
	 Scanner s=new Scanner(System.in);
     System.out.println("enter your email id");
     String email=s.next();
 	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
 	Query q=manager.createNamedQuery("findByEmail");
 	q.setParameter(1,email);
 	List<Person> persons=q.getResultList();
 	for(Person p:persons)
 	{
 		System.out.println(p);
 	}
     
 } 
}
