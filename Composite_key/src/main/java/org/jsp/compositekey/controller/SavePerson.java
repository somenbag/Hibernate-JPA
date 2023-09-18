package org.jsp.compositekey.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.compositekey.dto.Person;
import org.jsp.compositekey.dto.PersonId;

public class SavePerson 
{
public static void main(String[] args) {
Scanner s=new Scanner(System.in);
System.out.println("Enter your age,name,phone And email Id");
int age=s.nextInt();
String name=s.next();
long phone=s.nextLong();
String email=s.next();
PersonId id=new PersonId();
id.setPhone(phone);
id.setEmail(email);
Person p =new Person();
p.setName(name);
p.setAge(age);
p.setId(id);

EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
EntityTransaction transaction=manager.getTransaction();
manager.persist(p);
transaction.begin();
transaction.commit();

}
}
