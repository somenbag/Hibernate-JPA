package org.jsp.OneToManyOrManyToOne_controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.mapping.Array;
import org.jsp.OneToManyOrManyToOne_dto.Department;
import org.jsp.OneToManyOrManyToOne_dto.Employee;

public class SaveEmpAndDept 
{
public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	Department d=new Department();
	d.setName("development");
	d.setLocation("BTM Layout");
	
	Employee e1=new Employee();
	e1.setDept(d);
	e1.setDesg("trainer");
	e1.setName("ABC");
	e1.setSalary(1234);
	
	Employee e2=new Employee();
	e2.setDept(d);
	e2.setDesg("HR");
	e2.setName("XYZ");
	e2.setSalary(1034);
	
	Employee e3=new Employee();
	e3.setDept(d);
	e3.setDesg("tracker");
	e3.setName("PQR");
	e3.setSalary(234);
	
d.setEmps(new ArrayList<Employee>(Arrays.asList(e1,e2,e3)));
manager.persist(d);
transaction.begin();
transaction.commit();

}
}
