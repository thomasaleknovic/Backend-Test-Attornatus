package com.thomas.backendtestattronatus.repository.pessoa;

import com.thomas.backendtestattronatus.model.Endereco;
import com.thomas.backendtestattronatus.model.Pessoa;
import com.thomas.backendtestattronatus.repository.EnderecoJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class PessoaRepository implements IMemoRepository{

    private final PessoaJPARepository pessoaJPARepository;
    private final EnderecoJPARepository enderecoJPARepository;

    public PessoaRepository(PessoaJPARepository pessoaJPARepository, EnderecoJPARepository enderecoJPARepository) {
        this.pessoaJPARepository = pessoaJPARepository;
        this.enderecoJPARepository = enderecoJPARepository;
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        return this.pessoaJPARepository.save(pessoa);
    }

    @Override
    public Optional<Pessoa> findById(UUID id) {
        return this.pessoaJPARepository.findById(id);
    }

    public List<Pessoa> findAll() {
        return this.pessoaJPARepository.findAll();
    }

    @Override
    public Endereco saveEndereco(Endereco endereco) {

        return enderecoJPARepository.save(endereco);
    }

    @Override
    public Optional<Endereco> findEnderecoById(UUID id){
        return enderecoJPARepository.findById(id);

    }
    @Override
    public List<Endereco> findEnderecoByPessoaId(UUID id){
        return enderecoJPARepository.findByPessoaId(id);
    }

}
