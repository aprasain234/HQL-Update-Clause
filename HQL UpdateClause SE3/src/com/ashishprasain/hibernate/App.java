package com.ashishprasain.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashishprasain.hibernate.entity.Users;

public class App {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Users.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//  start transaction
			session.beginTransaction();
			session.createQuery("update users set password='asdfghjkl' where user_id=5").executeUpdate();
				
			
			//  Commit the transaction   ----------->>>>> committing is not necessary
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
								
	}
	
}
