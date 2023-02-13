package com.thomas.backendtestattronatus.services;

import com.thomas.backendtestattronatus.model.Pessoa;
import com.thomas.backendtestattronatus.repository.PessoaInMemoryRepository;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreatePessoaServiceTest {

    @Test
    public void should_be_able_to_create_a_new_pessoa() {

        //Create a new Pessoa
        //Create Pessoa Table(Entity)
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Thomas Aleknovic");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        pessoa.setDataNascimento(LocalDate.parse("02/09/2000", formatter));

        PessoaInMemoryRepository repository = new PessoaInMemoryRepository();

        PessoaService pessoaService = new PessoaService(repository);
        Pessoa createdCourse  = pessoaService.create(pessoa);


        assertNotNull(createdCourse.getId());

    }
}
