package com.thomas.backendtestattronatus.repository;

import com.thomas.backendtestattronatus.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class PessoaRepository implements IPessoaRepository{

    @Autowired
    PessoaJPARepository pessoaJPARepository;

    @Override
    public Pessoa save(Pessoa pessoa) {
        return this.pessoaJPARepository.save(pessoa);
    }

    @Override
    public Optional<Pessoa> findById(UUID id) {
        return this.pessoaJPARepository.findById(id);
    }
}
