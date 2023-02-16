package com.thomas.backendtestattronatus.controller;


import com.thomas.backendtestattronatus.model.Person;
import com.thomas.backendtestattronatus.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;


    @GetMapping
    public ResponseEntity<List<Person>> listAllPersons () {

        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById (@PathVariable UUID id) {

        return personService.findById(id)
                .map(personFound -> ResponseEntity.ok().body(personFound))
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping("/create")
    public ResponseEntity<Person> createPerson (@RequestBody Person person) {

        return ResponseEntity.ok(personService.create(person));

    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Person> updatePersonById (@PathVariable UUID id,
                                                    @RequestBody Person personUpdate) {

        return personService.findById(id)
                .map(personToUpdate -> personService.update(personToUpdate, personUpdate))
                .map(personUpdated -> ResponseEntity.ok().body(personUpdated))
                .orElse(ResponseEntity.notFound().build());
    }
}
