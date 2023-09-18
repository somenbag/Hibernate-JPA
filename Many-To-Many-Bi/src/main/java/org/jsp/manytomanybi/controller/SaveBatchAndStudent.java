package org.jsp.manytomanybi.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.manytomanybi.dto.Batch;
import org.jsp.manytomanybi.dto.Student;

public class SaveBatchAndStudent
{
public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		Batch b1=new Batch();
		b1.setSubject("hibernate");
		b1.setCode("sera2");
		
		Batch b2=new Batch();
		b2.setSubject("Spring");
		b2.setCode("sre3");
		
		Batch b3=new Batch();
		b3.setSubject("J2EE");
		b3.setCode("sdt3");
		
		Student s1=new Student();
		s1.setName("Virat");
		s1.setPerc(99);
		s1.setPhone(999987);
		
		Student s2=new Student();
		s2.setName("dhoni");
		s2.setPerc(94);
		s2.setPhone(888348);
		
		Student s3=new Student();
		s3.setName("rohit");
		s3.setPerc(95);
		s3.setPhone(6666);
		
		//Assign batch for s1
		s1.setBatches(new ArrayList<Batch>(Arrays.asList(b1,b2,b3)));
		
		//Assign batch for s2
		s2.setBatches(new ArrayList<Batch>(Arrays.asList(b1,b2,b3)));
			
		//Assign batch for s3
	    s3.setBatches(new ArrayList<Batch>(Arrays.asList(b1,b2,b3)));
	    
	    b1.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
	    b2.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
	    b3.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
	    
	    
	    EntityManager manager=factory.createEntityManager();
	    EntityTransaction transaction=manager.getTransaction();
	    manager.persist(b1);
	    manager.persist(b2);
	    manager.persist(b3);
	    
	    transaction.begin();
	    transaction.commit();
}
}
