package org.jsp.userproductapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.userproductapp.dto.User;

public class UserDao 
{
EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
public User saveUser(User user)
{
	EntityTransaction transaction=manager.getTransaction();
	manager.persist(user);
	transaction.begin();
	transaction.commit();
	return user;
}
public User updateUser(User user)

{
EntityTransaction transaction=manager.getTransaction();
manager.merge(user);
transaction.begin();
transaction.commit();
return user;
}
public User findUserById(int id)
{
	return manager.find(User.class, id);
}
public boolean deleteUser(int id)
{
	User u=findUserById(id);
	if(u!=null)
	{
		manager.remove(u);
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		transaction.commit();
		return true;
	} 
	return false;
}
public User verifyUser(long phone ,String password)
{
	String hql="select u from User u where u.phone=?1 and u.password=?1";
	Query q=manager.createQuery(hql);
	q.setParameter(1, phone);
	q.setParameter(2,password);
	try {
		return (User)q.getSingleResult();
	}
	catch(NoResultException e)
	{
	return null;	
	}
}
public User verifyUser(String email,String password) {
	String hql="select u from User u where u.email=?1 and u.password=?1";
	Query q=manager.createQuery(hql);
	q.setParameter(1,email);
	q.setParameter(2,password);
	try {
		return (User)q.getSingleResult();
	}
	catch(NoResultException e)
	{
	return null;	
	}
}
}
