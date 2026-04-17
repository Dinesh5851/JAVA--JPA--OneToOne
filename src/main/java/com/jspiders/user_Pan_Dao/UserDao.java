package com.jspiders.user_Pan_Dao;

import com.jspiders.user_Pan_Entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserDao {
	static EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
    static EntityManager manager=factory.createEntityManager();
	static EntityTransaction transaction=manager.getTransaction();
	
	public static void createUser(int userId,String userName,String Email,long Contact,String PanCardNumber)
	{
		User u1=new User();
		u1.setContact(Contact);
		u1.setEmail(Email);
		u1.setPanCardNumber(PanCardNumber);
		u1.addUserId(userId);
		u1.setUserName(userName);
			
		transaction.begin();
		manager.persist(u1);
		transaction.commit();
	}
	public static void find(int userId)
	{
		User u1=manager.find(User.class, userId);
		u1.getUserId();
		u1.getUserName();
		u1.getPanCardNumber();
			
	}
	public static void update(int userId,String userName,String Email)
	{
		User u2=manager.find(User.class, userId);
		if(u2!=null)
		{
		
			transaction.begin();
			u2.setContact(userId);
			u2.setEmail(Email);
			u2.setUserName(userName);
			manager.persist(u2);
			transaction.commit();
				
			
		}
		else
		{
			System.out.println("Invalid choice");
		}
				
	}
	public static void remove(int userId)
	{
		User u3=manager.find(User.class, userId);
		transaction.begin();
		manager.remove(u3);
		transaction.commit();
	}
	public static void findUser(int userId) {
	    User user = manager.find(User.class, userId);

	    if(user != null) {
	        System.out.println("User Id : " + user.getUserId());
	        System.out.println("User Name : " + user.getUserName());
	        System.out.println("Email : " + user.getEmail());
	        System.out.println("Contact : " + user.getContact());
	    } else {
	        System.out.println("User not found");
	    }

	}

}
