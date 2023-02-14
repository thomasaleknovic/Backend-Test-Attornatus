package com.thomas.backendtestattronatus.repository;

import com.thomas.backendtestattronatus.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EnderecoRepository extends JpaRepository <Endereco, UUID> {
    List<Endereco> findByPessoaId(UUID id);
}
