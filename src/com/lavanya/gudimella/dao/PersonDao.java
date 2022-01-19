package com.lavanya.gudimella.dao;

import java.util.ArrayList;         
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.lavanya.gudimella.dto.Person;
import com.lavanya.gudimella.hibernate.HibernateConfiguration;

public class PersonDao {
	
	@SuppressWarnings("unchecked")
	public Person[] getAllpersons() {
		List<Person> personsList = new ArrayList<Person>();
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		personsList = session.createQuery("from Person").list();
		Person[] personsArray = new Person[personsList.size()];
		for(int i=0;i<personsList.size();i++) {
			personsArray[i] = personsList.get(i);
		}
		transaction.commit();
		session.close();
		return personsArray;
	}

	public void savePerson(Person person) {
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(person);
		transaction.commit();
		session.close();
	}

	public void updatePerson(Person person) {
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(person);
		transaction.commit();
		session.close();
	}

	public void deletePerson(Person person) {
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(person);
		transaction.commit();
		session.close();
	}
	
	public Person getPersonById(int person_id) {
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Person person = session.get(Person.class, person_id);
		transaction.commit();
		session.close();
		return person;
	}

	public Person findByEmail(String email_address) {
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Person person = (Person) session.createQuery("from Person where email_address = :email_address").setParameter("email_address", email_address).getSingleResult();
		transaction.commit();
		session.close();
		return person;
	}

	@SuppressWarnings("unchecked")
	public boolean findUser(String email_address) {
		boolean isUserFound = false;
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<Person> personsList = new ArrayList<Person>();
		personsList = session.createQuery("from Person where email_address = :email_address").setParameter("email_address", email_address).getResultList();
		for(Person person : personsList) {
			String email = person.getEmail_address();
			if(email.trim().equals(email_address.trim())) {
				isUserFound=true;
			}
		}
		transaction.commit();
		session.close();
		return isUserFound;
	}
}
