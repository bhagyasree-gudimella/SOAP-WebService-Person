package com.lavanya.gudimella.service;

import com.lavanya.gudimella.dao.PersonDao; 
import com.lavanya.gudimella.dto.Person;

public class PersonService {
	
	public Person[] getAllPersons() {
		PersonDao personDao = new PersonDao();
		return personDao.getAllpersons();
	}
	
	public void savePerson(Person person) {
		PersonDao personDao = new PersonDao();
		personDao.savePerson(person);
	}

	public void updatePerson(Person person) {
		PersonDao personDao = new PersonDao();
		personDao.updatePerson(person);
	}

	public void deletePerson(Person person) {
		PersonDao personDao = new PersonDao();
		personDao.deletePerson(person);
	}

	public Person getPersonById(int person_id) {
		PersonDao personDao = new PersonDao();
		Person person = personDao.getPersonById(person_id);
		return person;
	}

	public Person findByEmail(String email_address) {
		PersonDao personDao = new PersonDao();
		Person person = personDao.findByEmail(email_address);
		return person;
	}
	
	public boolean findUser(String email_address) {
		PersonDao personDao = new PersonDao();
		return personDao.findUser(email_address);
	}
}
