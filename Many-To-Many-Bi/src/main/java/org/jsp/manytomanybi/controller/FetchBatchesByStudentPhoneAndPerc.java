package org.jsp.manytomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanybi.dto.Batch;

public class FetchBatchesByStudentPhoneAndPerc
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter student phone and  perc to display batches");
		long phone =s.nextLong();
		double perc=s.nextDouble();
		String qry="select s.batches from Student s where s.phone=?1 and s.perc=?2";
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2,perc);
		List<Batch> batches =q.getResultList();
		if(batches.size()>0)
		{
			for(Batch b: batches)
			{
				System.out.println(b);
			}
		}
		else {
			System.out.println("you have entered invalid phone and perc");
		}
	}
}
