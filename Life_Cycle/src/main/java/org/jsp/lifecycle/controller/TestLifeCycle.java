package org.jsp.lifecycle.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.lifecycle.dto.User;

public class TestLifeCycle 
{
public static void main(String[] args) {
	User u=new User();//transient state
	u.setId(1);
	u.setName("abc");
	u.setPhone(888);
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	manager.merge(u);//persistent states
	transaction.begin();
	transaction.commit();
	u.setName("virat");
	u.setPhone(99888);
	transaction.begin();
	transaction.commit();
	manager.detach(u); //detached states
	u.setName("rohit");
	u.setPhone(1234);
	transaction.begin();
	transaction.commit();
	
	
}
}
