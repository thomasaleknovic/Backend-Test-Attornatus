package com.thomas.backendtestattronatus.controller;


import com.thomas.backendtestattronatus.model.Pessoa;
import com.thomas.backendtestattronatus.repository.pessoa.PessoaRepository;
import com.thomas.backendtestattronatus.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;


    @GetMapping
    public List<Pessoa> listAllPessoa () {
        PessoaService pessoaService = new PessoaService(pessoaRepository);
        return pessoaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoaById (@PathVariable UUID id) {
        PessoaService pessoaService = new PessoaService(pessoaRepository);

        return pessoaService.findById(id)
                .map(recordFound -> ResponseEntity.ok().body(recordFound))
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping("/create")
    public Pessoa createPessoa (@RequestBody Pessoa pessoa) {
        PessoaService pessoaService = new PessoaService(pessoaRepository);
        return pessoaService.create(pessoa);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Pessoa> updatePessoaById (@PathVariable UUID id, @RequestBody Pessoa pessoa) {
        PessoaService pessoaService = new PessoaService(pessoaRepository);

        return pessoaService.findById(id)
                .map(pessoaFound -> {
                    pessoaFound.setNome(pessoa.getNome());
                    pessoaFound.setDataNascimento(pessoa.getDataNascimento());
                    return pessoaService.create(pessoaFound);
                })
                .map(pessoaFound -> ResponseEntity.ok().body(pessoaFound))
                .orElse(ResponseEntity.notFound().build());
    }
}
