package com.thomas.backendtestattronatus.services;

import com.thomas.backendtestattronatus.model.Pessoa;
import com.thomas.backendtestattronatus.repository.pessoa.IMemoRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Validated
@Service
public class PessoaService {

    private final IMemoRepository repository;

    public PessoaService(@Qualifier("pessoaRepository") IMemoRepository repository) {
        this.repository = repository;
    }


    public Pessoa create(Pessoa pessoa) {

       return repository.save(pessoa);
    }

    public List<Pessoa> findAll(){
        return repository.findAll();
    }

    public Optional<Pessoa> findById(UUID id) {
        return repository.findById(id);
    }
}
