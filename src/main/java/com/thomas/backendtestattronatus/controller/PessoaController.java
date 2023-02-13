package com.thomas.backendtestattronatus.controller;


import com.thomas.backendtestattronatus.model.Pessoa;
import com.thomas.backendtestattronatus.repository.PessoaRepository;
import com.thomas.backendtestattronatus.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping("/")
    public Pessoa createPessoa (Pessoa pessoa) {
        PessoaService pessoaService = new PessoaService(pessoaRepository);
        return pessoaService.create(pessoa);
    }
}
