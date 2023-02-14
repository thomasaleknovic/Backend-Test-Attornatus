package com.thomas.backendtestattronatus.repository.pessoa;

import com.thomas.backendtestattronatus.model.Endereco;
import com.thomas.backendtestattronatus.model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InMemoryRepository implements IMemoRepository{

    private List<Pessoa> pessoas;
    private List<Endereco> enderecos;

    public InMemoryRepository(){
        this.pessoas = new ArrayList<>();
        this.enderecos = new ArrayList<>();
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

    public List<Pessoa> findAll() {
        return this.pessoas;
    }

    @Override
    public Endereco saveEndereco(Endereco endereco) {

        this.enderecos.add(endereco);
        endereco.setId(UUID.randomUUID());
        return endereco;
    }

    @Override
    public Optional<Endereco> findEnderecoById(UUID id){
        return this.enderecos.stream().filter(
                        endereco -> endereco.getId().equals(id))
                .findFirst();

    }
    @Override
    public List<Endereco> findEnderecoByPessoaId(UUID id){
        return this.enderecos.stream().filter(endereco -> endereco.getPessoa().getId().equals(id)).toList();
    }



}
