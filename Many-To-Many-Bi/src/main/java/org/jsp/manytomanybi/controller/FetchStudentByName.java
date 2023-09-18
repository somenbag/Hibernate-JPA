package org.jsp.manytomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanybi.dto.Student;

public class FetchStudentByName
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name");
		String name=sc.next();
		String qry="select b from Student b where b.name=?1";
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createQuery(qry);
		q.setParameter(1, name);
		List<Student> students =q.getResultList();
		if(students.size()>0)
		{
			for(Student s: students)
			{
				System.out.println(s);
			}
		}
		else {
			System.out.println("you have entered invalid name");
		}
		}
}
