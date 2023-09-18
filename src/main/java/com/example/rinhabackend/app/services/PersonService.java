package com.example.rinhabackend.app.services;

import com.example.rinhabackend.app.DTOs.PersonDTO;
import com.example.rinhabackend.app.entities.Person;
import com.example.rinhabackend.app.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

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
        if(personRepository.existsByNickname(personDTO.nickname())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Esse apelido ja esta em uso");
        }

        var person = new Person();
        person.setName(personDTO.name());
        person.setNickname(personDTO.nickname());
        person.setBirthday(personDTO.birthday());
        person.setStackList(personDTO.stackList());

        personRepository.save(person);

        return person;
    }

    public Person findPersonById(UUID id) {
        var person = personRepository.findById(id);

        if(person.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa nao encontrada");
        }

        return person.get();
    }

    public List<Person> findPersonsByTerm(String term) {
        return personRepository
                .findAll()
                .stream()
                .filter(people -> people.getName().toLowerCase().contains(term) | people.getNickname().toLowerCase().contains(term) | people.getStackList().contains(term))
                .toList();
    }

    public Long countPersons() {
        return personRepository.count();
    }
}
