package com.concretepage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.concretepage.domain.PersonDTO;
import com.concretepage.service.PersonRepository;
import com.concretepage.service.PersonService;

@RestController
public class PersonRestController {

    @Autowired private PersonService personService;

    @Autowired private PersonRepository personRepository;

    // metodo get de bienvenida
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ResponseEntity < String > welcome() {
        return ResponseEntity.status(HttpStatus.OK).body("Welcome to Spring Boot");
    }

    @RequestMapping(value = "/persistPerson", method = RequestMethod.POST)
    public ResponseEntity < String > persistPerson(@RequestBody PersonDTO person) {
        if (personService.isValid(person)) {
            personRepository.persist(person);
            return ResponseEntity.status(HttpStatus.CREATED).body("Person created");
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("Person is not valid");
    }

    // metodo post que devuelva un ResponseEntity, que verifique si la edad de la persona es mayor a 18
    @RequestMapping(value = "/isAdult", method = RequestMethod.POST)
    public ResponseEntity < String > isAdult(@RequestBody PersonDTO person) {
        if (person.edad >= 18) {
            return ResponseEntity.status(HttpStatus.OK).body("Persona es mayor de edad");
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("Persona es menor de edad");
    }

    
    
}