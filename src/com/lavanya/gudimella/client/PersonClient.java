package com.lavanya.gudimella.client;

import com.lavanya.gudimella.dto.Person;
import com.lavanya.gudimella.service.PersonService;

public class PersonClient {
	public static void main(String[] args) {
		PersonService personService = new PersonService();
	
		Person[] personsList = personService.getAllPersons();
		for(Person person : personsList) {
			System.out.println(person.getFirst_name());
		}
	}
}
