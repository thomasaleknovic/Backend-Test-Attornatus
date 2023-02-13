package com.thomas.backendtestattronatus.services;

import com.thomas.backendtestattronatus.model.Pessoa;
import com.thomas.backendtestattronatus.repository.IPessoaRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class PessoaService {

    private final IPessoaRepository iPessoaRepository;

    public PessoaService(IPessoaRepository iPessoaRepository) {
        this.iPessoaRepository = iPessoaRepository;
    }


    public Pessoa create(Pessoa pessoa) {

       return iPessoaRepository.save(pessoa);
    }
}
