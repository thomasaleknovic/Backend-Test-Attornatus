package com.thomas.backendtestattronatus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Endereco {

    @Id
    private Long id;

    @NotNull
    @NotBlank
    @Column(length = 200, nullable = false)
    private String logradouro;

    @NotNull
    @NotBlank
    @Column(length = 10, nullable = false)
    private String cep;

    @NotNull
    @NotBlank
    @Column(length = 10, nullable = false)
    private String numero;

    @NotNull
    @NotBlank
    @Column(length = 50, nullable = false)
    private String cidade;


    @ManyToOne
    @NotNull
    private Pessoa pessoa;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
