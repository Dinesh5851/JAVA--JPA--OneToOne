package com.jspiders.user_Pan;

import com.jspiders.user_Pan_Dao.PanDao;
import com.jspiders.user_Pan_Dao.UserDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

//       UserDao.createUser(201, "Dinesh","dinesh@gmail.com", 98765432l, "2345678962");
//        PanDao.createPancard(201, "232323245", "dinesh", "23-09-2002", "mainroad poottai", 201);
//        PanDao.createPancard(202, "232323245", "dinesh", "23-09-2002", "mainroad poottai", 201);
//        PanDao.createPancard(203, "232323245", "dinesh", "23-09-2002", "mainroad poottai", 201);
//        UserDao.find(201);
//        PanDao.find(201);
//        UserDao.findUser(201);
//        PanDao.findpancard(201);
//        PanDao.findPanCard(201);
        UserDao.findUser(201);
        
       
        
        
    }
}