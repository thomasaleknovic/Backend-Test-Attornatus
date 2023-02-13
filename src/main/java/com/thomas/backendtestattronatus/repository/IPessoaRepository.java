package com.thomas.backendtestattronatus.repository;

import com.thomas.backendtestattronatus.model.Pessoa;

import java.util.Optional;
import java.util.UUID;

public interface IPessoaRepository {

    public Pessoa save(Pessoa pessoa);
    public Optional<Pessoa> findById(UUID id);
}
