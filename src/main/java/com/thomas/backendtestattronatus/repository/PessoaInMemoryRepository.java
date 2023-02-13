package com.thomas.backendtestattronatus.repository;

import com.thomas.backendtestattronatus.model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PessoaInMemoryRepository implements IPessoaRepository{

    private List<Pessoa> pessoas;

    public PessoaInMemoryRepository(){
        this.pessoas = new ArrayList<>();
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        this.pessoas.add(pessoa);
        pessoa.setId(UUID.randomUUID());
        return pessoa;
    }

    @Override
    public Optional<Pessoa> findById(UUID id) {
       return this.pessoas.stream().filter(
               pessoa -> pessoa.getId().equals(id))
               .findFirst();
    }
}
