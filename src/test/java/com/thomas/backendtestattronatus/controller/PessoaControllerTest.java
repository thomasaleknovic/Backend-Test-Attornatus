package com.thomas.backendtestattronatus.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.thomas.backendtestattronatus.model.Pessoa;
import com.thomas.backendtestattronatus.services.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PessoaController.class)
class PessoaControllerTest {

    @MockBean
    PessoaService pessoaService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void createPessoaTest() throws Exception {
//        Create a new Pessoa

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Thomas");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        pessoa.setDataNascimento(LocalDate.parse("02/09/2000", formatter));

        when(pessoaService.create(pessoa)).thenReturn(pessoa);

        mockMvc.perform(post("/pessoas/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonMapper.builder()
                        .findAndAddModules()
                        .build()
        .writeValueAsString(pessoa)))
                .andExpect(status().isOk());
    }

    @Test
    void listAllPessoaTest() throws Exception {

        // Create a new Pessoa

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Pessoa p1 = new Pessoa();
        p1.setNome("Thomas");
        p1.setId(UUID.randomUUID());
        p1.setDataNascimento(LocalDate.parse("02/09/2000", formatter));

        Pessoa p2 = new Pessoa();
        p2.setNome("Carlos");
        p2.setId(UUID.randomUUID());
        p2.setDataNascimento(LocalDate.parse("12/02/2010", formatter));

        List<Pessoa> pessoaList = Arrays.asList(p1,p2);

        when(pessoaService.findAll()).thenReturn(pessoaList);

        mockMvc.perform(get("/pessoas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }

    @Test
    void getPessoaByIdTest() throws Exception {
        // Create a new Pessoa

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Thomas");
        pessoa.setId(UUID.randomUUID());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        pessoa.setDataNascimento(LocalDate.parse("02/09/2000", formatter));


        when(pessoaService.findById(pessoa.getId())).thenReturn(Optional.of(pessoa));

        mockMvc.perform(get("/pessoas/{id}", pessoa.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Thomas"));

    }
//    @Test
//    void updatePessoaById() throws Exception {
//
//
//        Pessoa pessoa = new Pessoa();
//        pessoa.setNome("Thomas");
//        pessoa.setId(UUID.randomUUID());
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        pessoa.setDataNascimento(LocalDate.parse("02/09/2000", formatter));
//
//        Pessoa updatePessoa = new Pessoa();
//        updatePessoa.setNome("Carlos");
//        updatePessoa.setId(pessoa.getId());
//        updatePessoa.setDataNascimento(LocalDate.parse("02/09/2000", formatter));
//
//        when(pessoaService.create(pessoa)).thenReturn(pessoa);
//        when(pessoaService.update(updatePessoa)).thenReturn(updatePessoa);
//
//        MvcResult result = mockMvc.perform(post("/pessoas/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(JsonMapper.builder()
//                                .findAndAddModules()
//                                .build()
//                                .writeValueAsString(pessoa)))
//                .andReturn();
//
//        mockMvc.perform(put("/pessoas/{id}/update", pessoa.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(JsonMapper.builder()
//                                .findAndAddModules()
//                                .build()
//                                .writeValueAsString(updatePessoa)))
//                .andDo(MockMvcResultHandlers.print());
//
//
//
//    }
}