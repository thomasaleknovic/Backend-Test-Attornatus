package com.thomas.backendtestattronatus.repository;

import com.thomas.backendtestattronatus.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository <Endereco, Long> {
}
