package com.jspider.AadharDAo;

import com.jspider.AadharEntity.Aadhar;
import com.jspider.AadharEntity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserDao {

    static EntityManagerFactory factory =Persistence.createEntityManagerFactory("development");
    static EntityManager manager = factory.createEntityManager();
    static EntityTransaction transaction = manager.getTransaction();

    public static void createUser(String name, String email, long contact) {

        User user = new User();
        user.setUserName(name);
        user.setEmail(email);
        user.setContact(contact);

        transaction.begin();
        manager.persist(user);
        transaction.commit();

        System.out.println("User Saved Successfully!");
    }
    public static void findUser(int userId) {

        User user = manager.find(User.class, userId);

        if (user != null) {
            System.out.println("User ID: " + user.getUserId());
            System.out.println("Name: " + user.getUserName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Contact: " + user.getContact());

            if (user.getAadhar() != null) {
                System.out.println("Aadhar Number: " + user.getAadhar().getAadharNumber());
            }
        } else {
            System.out.println("User Not Found");
        }
    }

    public static void update(int UserId,String newemail,String name) {
		User e=manager.find(User.class,UserId);
		 if(e!=null)
		 {
			 transaction.begin();
			 e.setEmail(newemail);
			 e.setUserName(name);
			 manager.persist(e);
			 transaction.commit();
			 System.out.println("Updated!!!");
			
		 }
		 else {
			 System.out.println("InvalidId");
		 }
	 
	}
    public static void deleteUser(int userId) {

        User user = manager.find(User.class, userId);

        if (user != null) {

            transaction.begin();

            manager.remove(user);

            transaction.commit();

            System.out.println("User Deleted Successfully!");
        } else {
            System.out.println("User Not Found");
        }
    }

}
