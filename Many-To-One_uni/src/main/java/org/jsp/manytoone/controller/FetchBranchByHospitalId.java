package org.jsp.manytoone.controller;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.manytoone.dto.Branch;
public class FetchBranchByHospitalId 
{
public static void main(String[] args)
{
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	String qry="select b from Branch b where b.hospital.id=?1";
	Scanner s=new Scanner(System.in);
	System.out.println("enter the hospital id to display branch details");
	int hid=s.nextInt();
	Query q=manager.createQuery(qry);
	q.setParameter(1,hid);
	List<Branch> branches=q.getResultList();
	if(branches.size()>0)
	{
	for(Branch b:branches)
	{
		System.out.println("id:"+b.getId());
		System.out.println("name:"+b.getName());
	}}
	else
	{
		System.err.println("invalid id");
	}
}}

