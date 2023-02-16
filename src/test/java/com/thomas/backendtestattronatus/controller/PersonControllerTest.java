package com.thomas.backendtestattronatus.controller;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.thomas.backendtestattronatus.model.Person;
import com.thomas.backendtestattronatus.services.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @MockBean
    PersonService personService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void createPessoaTest() throws Exception {
//        Create a new Pessoa

        Person person = new Person();
        person.setName("Thomas");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        person.setBirthDate(LocalDate.parse("02/09/2000", formatter));

        when(personService.create(person)).thenReturn(person);

        mockMvc.perform(post("/persons/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonMapper.builder()
                        .findAndAddModules()
                        .build()
        .writeValueAsString(person)))
                .andExpect(status().isOk());
    }

    @Test
    void listAllPessoaTest() throws Exception {

        // Create a new Pessoa

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Person p1 = new Person();
        p1.setName("Thomas");
        p1.setId(UUID.randomUUID());
        p1.setBirthDate(LocalDate.parse("02/09/2000", formatter));

        Person p2 = new Person();
        p2.setName("Carlos");
        p2.setId(UUID.randomUUID());
        p2.setBirthDate(LocalDate.parse("12/02/2010", formatter));

        List<Person> personList = Arrays.asList(p1,p2);

        when(personService.findAll()).thenReturn(personList);

        mockMvc.perform(get("/persons")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }

    @Test
    void getPessoaByIdTest() throws Exception {
        // Create a new Pessoa

        Person person = new Person();
        person.setName("Thomas");
        person.setId(UUID.randomUUID());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        person.setBirthDate(LocalDate.parse("02/09/2000", formatter));


        when(personService.findById(person.getId())).thenReturn(Optional.of(person));

        mockMvc.perform(get("/persons/{id}", person.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Thomas"));

    }
}