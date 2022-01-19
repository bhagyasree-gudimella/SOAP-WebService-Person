package com.lavanya.gudimella.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
	
	private static Configuration configuration;
	private static SessionFactory sessionfactory;
	
	static {
		configuration = new Configuration();
		sessionfactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	/**
	 * get the session factory to store the Person values into the database
	 * @return sessionfactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionfactory;
	}
}
