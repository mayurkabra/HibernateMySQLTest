package com.hibernate.test.demo;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;

import com.hibernate.test.pojo.Student;
import com.hibernate.test.util.HibernateUtil;  
  
  
public class DemoFirst {  
  
    public static void main(String[] args) {  
  
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();  
          
        try {
			Student student = new Student();  
			student.setFirstName("Stro");  
			student.setAge(26);  
			  
			session.save(student);  
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
          
        session.close();  
  
    }  
}  