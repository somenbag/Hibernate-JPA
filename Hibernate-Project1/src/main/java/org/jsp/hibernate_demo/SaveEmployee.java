package org.jsp.hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveEmployee {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setName("Aryan");
		e.setDesg("student");
		e.setSalary(5000);
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		s.save(e);
		Transaction t = s.beginTransaction();
		t.commit();
		System.out.println("Employee saved with Id:" + e.getId());
	}
}
