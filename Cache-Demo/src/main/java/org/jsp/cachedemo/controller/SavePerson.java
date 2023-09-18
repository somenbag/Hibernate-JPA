package org.jsp.cachedemo.controller;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.cachedemo.dto.Person;

public class SavePerson 
{
public static void main(String[] args) {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	Person p=new Person();
	p.setName("abc");
	p.setPhone(777);
	manager.persist(p);
	transaction.begin();
	transaction.commit();
	
}
}
