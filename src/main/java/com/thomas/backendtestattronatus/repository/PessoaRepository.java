package com.thomas.backendtestattronatus.repository;

import com.thomas.backendtestattronatus.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository <Pessoa, Long> {
}
