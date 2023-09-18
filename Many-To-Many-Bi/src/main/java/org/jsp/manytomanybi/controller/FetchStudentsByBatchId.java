package org.jsp.manytomanybi.controller;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.manytomanybi.dto.Batch;
public class FetchStudentsByBatchId 
{
public static void main(String[] args)
{
Scanner s=new Scanner(System.in);
System.out.println("Enter the batch id");
int sid=s.nextInt();

String qry="select b.students from Batch b where b.id=?1";
EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
Query q=manager.createQuery(qry);
q.setParameter(1, sid);
List<Batch> batches =q.getResultList();
if(batches.size()>0)
{
	for(Batch b: batches)
	{
		System.out.println(b);
	}
}
else {
	System.out.println("you have entered invalid id");
}
}
}
