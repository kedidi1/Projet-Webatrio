package com.webatrio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webatrio.dto.PersonDTO;
import com.webatrio.entities.Person;
import com.webatrio.services.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personService.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    @GetMapping
    public List<PersonDTO> getAllPersons() {
        List<PersonDTO> persons = personService.getAllPersonsOrderedByNameWithAgeAndCurrentJobs();
        return persons;
    }

    @GetMapping("/company/{companyName}")
    public List<Person> getPersonsByCompany(@PathVariable String companyName) {
        List<Person> persons = personService.getPersonsByCompany(companyName);
        return persons;
    }
}