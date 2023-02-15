package com.concretepage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.concretepage.domain.PersonDTO;

@Repository
public class PersonRepository {
	List<PersonDTO> listaPersonas = new ArrayList<PersonDTO>();
	

	public void persist(PersonDTO person) {
		listaPersonas.add(person);
		System.out.println("Persistiendo persona: " + person.nombre);		
	}

	

}
