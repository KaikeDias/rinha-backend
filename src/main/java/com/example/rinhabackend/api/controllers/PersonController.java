package com.example.rinhabackend.api.controllers;

import com.example.rinhabackend.app.DTOs.PersonDTO;
import com.example.rinhabackend.app.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/pessoas")
    public ResponseEntity<Object> createPerson(@RequestBody @Valid PersonDTO personDTO) {
        try {
            var person = personService.savePerson(personDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(person);
        } catch (ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
        }
    }

    @GetMapping("/pessoas")
    public ResponseEntity<Object> getAllPersons() {
        try {
            var persons = personService.findAll();
            return ResponseEntity.ok(persons);
        } catch (ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
        }
    }

}
