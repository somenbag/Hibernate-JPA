package org.jsp.onetooneuni_controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Test 
{   public static void main(String[] args) {
	
	EntityManager managaer=Persistence.createEntityManagerFactory("dev").createEntityManager();
	System.out.println("complete");
   
}}
