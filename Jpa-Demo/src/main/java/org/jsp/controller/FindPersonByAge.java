package org.jsp.controller;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.dto.Person;

public class FindPersonByAge 
{
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("enter the age to find the person");
	int age=s.nextInt();
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	Query q=manager.createNamedQuery("findByAge");
	q.setParameter(1, age);
	List<Person> persons=q.getResultList();
	for(Person p:persons)
	{   
		System.out.println(p);
	}
}
}
