package org.jsp.onetooneuni_controller;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.onetooneuni_dto.PanCard;
import org.jsp.onetooneuni_dto.Person;

public class SavePersonAndCard 
{
public static void main(String[] args) {
	Person p=new Person();
	p.setName("abc");
	p.setPhone(7777);
	p.setAge(24);
	PanCard card=new PanCard();
	card.setDob(LocalDate.parse("1988-11-07"));
	card.setNumber("ifelse13452");
	card.setPincode(123456);
	p.setCard(card); //assigning pancard for person
	
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	manager.persist(p);
	transaction.begin();
	transaction.commit();
	
}
}
	