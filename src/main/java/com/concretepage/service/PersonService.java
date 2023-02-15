package com.concretepage.service;

import org.springframework.stereotype.Service;

import com.concretepage.domain.PersonDTO;

@Service
public class PersonService {

	public boolean isValid(PersonDTO person) {
		if (person.nombre == null || person.nombre.isEmpty()) {
			return false;
		}
		if (person.edad < 0) {
			return false;
		}
		if (person.profesion == null || person.profesion.isEmpty()) {
			return false;
		}
		return true;
	}

	


}
