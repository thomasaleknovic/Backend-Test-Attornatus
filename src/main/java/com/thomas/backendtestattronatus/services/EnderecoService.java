package com.thomas.backendtestattronatus.services;

import com.thomas.backendtestattronatus.model.Endereco;
import com.thomas.backendtestattronatus.repository.pessoa.IMemoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnderecoService {
    private final IMemoRepository repository;

    public EnderecoService(IMemoRepository repository) {
        this.repository = repository;
    }

    public Endereco create(Endereco endereco) {

        return repository.saveEndereco(endereco);
    }

    public Optional<Endereco> findEnderecoById(UUID id){
        return repository.findEnderecoById(id);

    }
    public List<Endereco> findEnderecoByPessoaId(UUID id){
        return repository.findEnderecoByPessoaId(id);

    }




}
