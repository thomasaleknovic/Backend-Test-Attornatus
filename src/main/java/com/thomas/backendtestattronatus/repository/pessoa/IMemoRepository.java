package com.thomas.backendtestattronatus.repository.pessoa;

import com.thomas.backendtestattronatus.model.Endereco;
import com.thomas.backendtestattronatus.model.Pessoa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IMemoRepository {

    public Pessoa save(Pessoa pessoa);
    public Optional<Pessoa> findById(UUID id);
    public List<Pessoa> findAll();

    public Endereco saveEndereco(Endereco endereco);
    public Optional<Endereco> findEnderecoById(UUID id);
    public  List<Endereco> findEnderecoByPessoaId(UUID id);
}
