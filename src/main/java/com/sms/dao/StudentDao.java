package com.sms.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sms.dto.Admin;
import com.sms.dto.Student;

public class StudentDao {
	public static Session getsession()
	{
		SessionFactory sessionFactory=new Configuration().configure()
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Admin.class)
				.buildSessionFactory();
		Session session=sessionFactory.openSession();
		return session;
	}
	
	public void saveStudent(Student student)
	{
		Session session=StudentDao.getsession();
		Transaction trans=session.beginTransaction();
		session.save(student);
		trans.commit();
		session.close();
	}
}
