package org.jsp.hibernate_demo;
import java.util.Scanner;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchEmployeeByDesignation  {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter your designation to display the details");;
	String desg=sc.nextLine();
	String hql="select e from Employee e where e.design=?1";
	Session s=new Configuration().configure().buildSessionFactory().openSession();
	Query<Employee> q=s.createQuery(hql);
	q.setParameter(1,desg);
	try {
		Employee e=q.getSingleResult();
		System.out.println(e);
	}
	catch(NoResultException e )
	{
		System.err.println("you have entered an Invalid designation");
	}
}
}
