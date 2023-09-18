package org.jsp.userproductapp.controller;
import java.util.Scanner;
import org.jsp.userproductapp.dao.ProductDao;
import org.jsp.userproductapp.dao.UserDao;
import org.jsp.userproductapp.dto.Product;
import org.jsp.userproductapp.dto.User;
public class UserController
{
   static Scanner s=new Scanner(System.in);
   static ProductDao pDao= new ProductDao();
   static UserDao uDao = new UserDao();
   public static void main(String[] args)
   {
	System.out.println("1.Register"               );
	System.out.println("2.Update"                 );
	System.out.println("3.verify user by phone and password");
	System.out.println("4.verify user by email and password");
	System.out.println("5.Add product"             );
	System.out.println("6.View product by user id" );
	System.out.println("7.View product by category");
	System.out.println("8. View product by brand"  );
	int choice=s.nextInt();
	switch (choice) 
	{
	case 1:
	{
		save();
		break;
	}
	case 2:
	{
		update();
		break;
	}
	case 5:
	{
		addProduct();
		break;
	}
	case 6:
	{
		viewProductByuserid();
		break;
	}
}
}
public static void save()
{
	System.out.println("Enter your name,email,phone and password to register");
	String name=s.next();
	String email=s.next();
	long phone=s.nextLong();
	String password=s.next();
	User u=new User();
	u.setName(name);
	u.setEmail(email);
	u.setPassword(password);
	u.setPhone(phone);
	u=uDao.saveUser(u);
	System.out.println("you are register with id:"+u.getId());
}
public static void update()
{   
	System.out.println("Enter Your Id");
	int id=s.nextInt();
	System.out.println("Enter your name,email,phone and password to update");
	String name=s.next();
	String email=s.next();
	long phone =s.nextLong();
	String password=s.next();
	User u = new User();
	u.setId(id);
	u.setName(name);
	u.setEmail(email);
	u.setPhone(phone);
	u.setPassword(password);
	u=uDao.updateUser(u);
	System.out.println("You account is update with id:"+u.getId());
	
}

public static void addProduct()
{
	System.out.println("Enter your id to add the product");
	int uid=s.nextInt();
	System.out.println("Enter the name,brand,category,price");
	String name=s.next();
	String brand=s.next();
	String category=s.next();
	double price=s.nextDouble();
	Product p=new Product();
	p.setBrand(brand);
	p.setName(name);
	p.setCategroy(category);
	p.setPrice(price);
	p=pDao.saveProduct(p,uid);
	if(p!=null)
	{
		System.out.println("Product added to the cart with id:"+p.getId());
	}
	else
	{
		System.err.println("user with the entered id not present");
	}
}
public static void viewProductByuserid()
{
	System.out.println("Enter your id to display products");   
		int id=s.nextInt();
		User u = new User();
		//u=pDao.viewProductByuserid(id);
		System.out.println(u);
		System.out.println("your id");
} }