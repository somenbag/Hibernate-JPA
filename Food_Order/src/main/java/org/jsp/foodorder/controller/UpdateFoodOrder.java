package org.jsp.foodorder.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.foodorder.dto.FoodOrder;

public class UpdateFoodOrder 
{
public static void main(String[] args) {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager =factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	FoodOrder order = manager.find(FoodOrder.class,1);
    order.setCost(250);
    manager.persist(order);
    transaction.begin();
    transaction.commit();
}
}
