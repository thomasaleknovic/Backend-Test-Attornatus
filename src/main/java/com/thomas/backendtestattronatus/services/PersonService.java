package com.thomas.backendtestattronatus.services;

import com.thomas.backendtestattronatus.model.Person;
import com.thomas.backendtestattronatus.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Validated
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    public Person create(Person person) {

        return personRepository.save(person);

    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Optional<Person> findById(UUID id) {
        return personRepository.findById(id);
    }

    public Person update(Person personToUpdate, Person personUpdate) {
        personToUpdate.setName(personUpdate.getName());
        personToUpdate.setBirthDate(personUpdate.getBirthDate());
        return personRepository.save(personToUpdate);
    }

}
