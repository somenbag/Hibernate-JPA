package org.jsp.manytoone.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytoone.dto.Hospital;

public class FetchHospitalByBranchId 
{
public static void main(String[] args) {
	String qry = "select b.hospital from Branch b where b.id=?1";
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the branch id to display hospital details");
	int bid=s.nextInt();
	Query q= manager.createQuery(qry);
	q.setParameter(1, bid);
	try {
	      Hospital h=(Hospital)q.getSingleResult();
	      System.out.println("id:"+h.getId());
	      System.out.println("name:"+h.getName());
	}
	catch(NoResultException e)
	{
		System.err.println("invalid branch id");
	}
}
}
