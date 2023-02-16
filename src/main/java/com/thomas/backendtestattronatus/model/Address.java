package com.thomas.backendtestattronatus.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @NotBlank
    @Column(length = 200, nullable = false)
    private String personAddress;


    @NotNull
    @NotBlank
    @Column(length = 10, nullable = false)
    private String cep;

    @NotNull
    @NotBlank
    @Column(length = 10, nullable = false)
    private String number;

    @NotNull
    @NotBlank
    @Column(length = 50, nullable = false)
    private String city;

    @Column(length = 10, nullable = false)
    private Boolean mainAddress = false;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(Boolean mainAddress) {
        this.mainAddress = mainAddress;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }



}
