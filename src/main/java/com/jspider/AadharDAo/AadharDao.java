package com.jspider.AadharDAo;

import com.jspider.AadharEntity.Aadhar;
import com.jspider.AadharEntity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AadharDao {

    static EntityManagerFactory factory =Persistence.createEntityManagerFactory("development");
    static EntityManager manager = factory.createEntityManager();
    static EntityTransaction transaction = manager.getTransaction();

    public static void createAadhar(String number,String name,String dob,String address,int userId) {

        Aadhar aadhar = new Aadhar();
        aadhar.setAadharNumber(number);
        aadhar.setName(name);
        aadhar.setDob(dob);
        aadhar.setAddress(address);

        User user = manager.find(User.class, userId);
        user.setAadhar(aadhar);
        transaction.begin();
        manager.persist(aadhar);
        transaction.commit();

        System.out.println("Aadhar Linked Successfully!");
    }
   
}
