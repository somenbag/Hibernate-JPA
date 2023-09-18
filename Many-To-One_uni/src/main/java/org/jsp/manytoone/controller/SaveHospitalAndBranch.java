package org.jsp.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.manytoone.dto.Branch;
import org.jsp.manytoone.dto.Hospital;

public class SaveHospitalAndBranch
{
public static void main(String[] args) {
	Hospital h=new Hospital();
	h.setName("Apllo");
	h.setGst("apl123");
	h.setFounder("ABC");
	
	Branch b1 =new Branch();
	b1.setName(" apllo banglore");
	b1.setEmail("AB@gamil.com");
	b1.setPhone(77777);
	b1.setHospital(h);
	
	Branch b2 =new Branch();
	b2.setName(" apllo manglore");
	b2.setEmail("LMN@gamil.com");
	b2.setPhone(8888);
	b2.setHospital(h);
	
	Branch b3 =new Branch();
	b3.setName(" apllo mysore");
	b3.setEmail("XYZ@gamil.com");
	b3.setPhone(9999);
	b3.setHospital(h);
	
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	manager.persist(b1);
	manager.persist(b2);
	manager.persist(b3);

	transaction.begin();
	transaction.commit();
}
}
