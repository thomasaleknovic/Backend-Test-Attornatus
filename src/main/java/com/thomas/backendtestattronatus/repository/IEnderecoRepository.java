package com.thomas.backendtestattronatus.repository;

import com.thomas.backendtestattronatus.model.Endereco;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEnderecoRepository {

    public Endereco save(Endereco endereco);
    public Optional<Endereco> findById(UUID id);
    public List<Endereco> findAllByPessoaId();
}
