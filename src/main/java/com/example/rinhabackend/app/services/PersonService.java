package com.example.rinhabackend.app.services;

import com.example.rinhabackend.app.DTOs.PersonDTO;
import com.example.rinhabackend.app.entities.Person;
import com.example.rinhabackend.app.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person savePerson(PersonDTO personDTO) {
        var person = new Person();
        person.setName(personDTO.name());
        person.setNickname(personDTO.nickname());
        person.setBirthday(personDTO.birthday());
        person.setStackList(personDTO.stackList());

        personRepository.save(person);

        return person;
    }
}
