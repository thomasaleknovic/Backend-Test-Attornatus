package com.thomas.backendtestattronatus.services;

import com.thomas.backendtestattronatus.model.Pessoa;
import com.thomas.backendtestattronatus.repository.pessoa.InMemoryRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PessoaServiceTest {

    public Pessoa createPessoa (String nome, String dataNascimento) {

        //Create a new Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        pessoa.setDataNascimento(LocalDate.parse(dataNascimento, formatter));


        // Create a new Pessoa in DB
        return pessoa;
    }

    @Test
    public void should_be_able_to_create_a_new_pessoa() {

        // Instance a repository and the service
        InMemoryRepository repository = new InMemoryRepository();
        PessoaService pessoaService = new PessoaService(repository);

        //Create a new Pessoa
        Pessoa pessoa = createPessoa("Thomas Aleknovic", "02/02/2000");
        Pessoa createdPessoa = pessoaService.create(pessoa);

        assertNotNull(createdPessoa.getId());

    }

    @Test
    public void should_be_able_to_list_all_pessoas() {

        // Instance a repository and the service
        InMemoryRepository repository = new InMemoryRepository();
        PessoaService pessoaService = new PessoaService(repository);

        //Create a new Pessoas
        Pessoa p1 = createPessoa("John Martinez", "15/03/1986");
        Pessoa p2 = createPessoa("Thomas Aleknovic", "02/02/2000");
        pessoaService.create(p1);
        pessoaService.create(p2);

        // List Created Pessoas
        List<Pessoa> foundPessoas = pessoaService.findAll();

        assertEquals(2, foundPessoas.size());

    }

    @Test
    public void should_be_able_to_list_one_pessoa_by_its_id() {

        // Instance a repository and the service
        InMemoryRepository repository = new InMemoryRepository();
        PessoaService pessoaService = new PessoaService(repository);


        //Create a new Pessoa
        Pessoa p1 = createPessoa("John Martinez", "15/03/1986");
        Pessoa createdP1  = pessoaService.create(p1);


        // Get Created Pessoa
       Pessoa foundPessoa = pessoaService.findById(createdP1.getId()).orElse(null);


        assert foundPessoa != null;
        assertEquals(createdP1.getId(), foundPessoa.getId());


    }

    @Test
    public void should_be_able_to_list_edit_pessoa_by_its_id() {

        // Instance a repository and the service
        InMemoryRepository repository = new InMemoryRepository();
        PessoaService pessoaService = new PessoaService(repository);


        //Create a new Pessoa
        Pessoa p1 = createPessoa("John Martinez", "15/03/1986");
        Pessoa createdP1  = pessoaService.create(p1);


        // Get Created Pessoa
        Pessoa updatedPessoa = pessoaService.findById(createdP1.getId()).map(pessoa -> {
            pessoa.setNome("Thomas Aleknovic");
            pessoa.setDataNascimento(LocalDate.parse("02/09/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            return pessoaService.create(pessoa);
        }).orElse(null);


        assert updatedPessoa != null;
        assertEquals("Thomas Aleknovic", updatedPessoa.getNome());


    }
}
