package org.jsp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.dto.Person;

public class DeletePerson 
{
 public static void main(String[] args) {
	EntityManager managaer=Persistence.createEntityManagerFactory("dev").createEntityManager();
	System.out.println("Enter your id to delete the record");
	Scanner s=new Scanner(System.in);
    int id=s.nextInt();
    Person p=managaer.find(Person.class, id);
    if(p!=null)
    {
     managaer.remove(p);
     EntityTransaction transaction=managaer.getTransaction();
     transaction.begin();
     transaction.commit();
     System.out.println("record is deleted");
     
    }
    else
    {
    	System.err.println("you have entered invalid id");
    }
 }
}
