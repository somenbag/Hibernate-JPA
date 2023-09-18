package org.jsp.manytomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanybi.dto.Batch;

public class FetchBatchBySubject 
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter subject ");
		String sub=s.next();
		String qry="select b from Batch b where b.subject=?1";
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createQuery(qry);
		q.setParameter(1, sub);
		List<Batch> batches =q.getResultList();
		if(batches.size()>0)
		{
			for(Batch b: batches)
			{
				System.out.println(b);
			}
		}
		else {
			System.out.println("you have entered invalid subject");
		}
	}
}
