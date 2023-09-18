package org.jsp.manytomany.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.manytomany.dto.Batch;
import org.jsp.manytomany.dto.Student;


public class SaveStudentAndBatch 
{
public static void main(String[] args) {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	Batch b1=new Batch();
	b1.setSubject("hibernate");
	b1.setCode("SEHE5");
	
	Batch b2=new Batch();
	b2.setSubject("Spring");
	b2.setCode("SGTH6");
	
	Batch b3=new Batch();
	b3.setSubject("J2EE");
	b3.setCode("SUY04");
	
	Student s1=new Student();
	s1.setName("Virat");
	s1.setPerc(92);
	s1.setPhone(999987);
	
	Student s2=new Student();
	s2.setName("dhoni");
	s2.setPerc(98);
	s2.setPhone(888348);
	
	Student s3=new Student();
	s3.setName("rohit");
	s3.setPerc(97);
	s3.setPhone(6666);
	
	//Assign Student for b1
	b1.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
	
	//Assign Student for b2
	b2.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
		
	//Assign Student for b2
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
