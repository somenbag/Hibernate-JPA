package org.jsp.hibernate_demo;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class UpdateEmployee 
{
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("enter your Employee id to update the details ");
	int eid=s.nextInt();
	System.out.println("enter the name ,designation &salary");
	String name=s.next();
	String desg=s.next();
    double salary =s.nextDouble();
    Employee e=new Employee();
    e.setId(eid);
    e.setName(name);
    e.setSalary(salary);
    e.setDesg(desg);
    Session session =new Configuration().configure().buildSessionFactory().openSession();
    Transaction t=session.beginTransaction();
    session.saveOrUpdate(e);
    t.commit();
}
}
