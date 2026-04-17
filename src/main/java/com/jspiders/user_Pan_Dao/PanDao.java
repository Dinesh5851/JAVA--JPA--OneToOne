package com.jspiders.user_Pan_Dao;

import com.jspiders.user_Pan_Entity.User;
import com.jspiders.user_Pan_Entity.panCard;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PanDao {
	static EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
    static EntityManager manager=factory.createEntityManager();
	static EntityTransaction transaction=manager.getTransaction();

	public static void createPancard(int panId,String panCardNumber,String name,String dob,String address,int userId)
	{
	    User user = manager.find(User.class, userId);

	    panCard card = new panCard();
	    card.setPanId(panId);
	    card.setName(name);
	    card.setPanCardNumber(panCardNumber);
	    card.setDOB(dob);
	    card.setAddress(address);

//	    if(user != null){
//	        card.addUser(user);
//	    }

	    transaction.begin();
	    manager.persist(card);
	    transaction.commit();
	}
	public static void findpancard(int panId) {

	    panCard pancard = manager.find(panCard.class, panId);

	    if (pancard != null) {

	        User user = pancard.getUser();

	        if (user != null) {
	            System.out.println("User Email : " + user.getEmail());
	        } else {
	            System.out.println("No user linked with this pancard");
	        }

	    } else {
	        System.out.println("Pancard not found");
	    }
	}
	public static void find(int panId)
	{
	    panCard p1 = manager.find(panCard.class, panId);

	    if(p1 != null) {
	        System.out.println("Name : " + p1.getName());
	        System.out.println("Pan Number : " + p1.getPanCardNumber());
	    }
	}
	public static void findPanCard(int panId) {

	    panCard pan = manager.find(panCard.class, panId);

	    if(pan != null) {
	        System.out.println("Pan Id : " + pan.getPanId());
	        System.out.println("Name : " + pan.getName());
	        System.out.println("DOB : " + pan.getDOB());
	        System.out.println("Address : " + pan.getAddress());
	        System.out.println("Pan Number : " + pan.getPanCardNumber());
	    } 
	    else {
	        System.out.println("PanCard not found");
	    }

	}
}

