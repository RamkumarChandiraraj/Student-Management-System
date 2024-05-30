package com.sms.dao;



import java.util.List;

import javax.persistence.Query;

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

	public List<Student> getAllStudents(Admin admin)
	{
		Session session=StudentDao.getsession();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("select s from Student s where s.admin=?1");
		query.setParameter(1, admin);
		List students=query.getResultList();
		return students;
	}
}
