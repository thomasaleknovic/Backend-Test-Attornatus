package com.thomas.backendtestattronatus.repository.pessoa;
import com.thomas.backendtestattronatus.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaRepository extends JpaRepository <Pessoa, UUID> {
}
