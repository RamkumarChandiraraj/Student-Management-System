package com.sms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

import com.sms.dto.Admin;

public class AdminDao {

	public static Session getSession()
	{
		SessionFactory sessionFactory=new Configuration().configure().addAnnotatedClass(Admin.class).buildSessionFactory();
		Session session=sessionFactory.openSession();
		return session;
	}
	public void adminSignUp(Admin admin)
	{
		Session session=AdminDao.getSession();
		Transaction trans=session.beginTransaction();
		session.save(admin);
		trans.commit();
		session.close();
	}
	public Admin adminLogin(String email, String password)
	{
		try {
			Session session=AdminDao.getSession();
			Query query=session.createQuery("select a from Admin a where a.adminEmail=?1 and a.adminPassword=?2");
			query.setParameter(1, email);
			query.setParameter(2, password);
			Admin admin=(Admin)query.getSingleResult();
			return admin;
		}
		catch(Exception exception)
		{
			return null;
		}
	}
}
