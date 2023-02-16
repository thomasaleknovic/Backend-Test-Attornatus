package com.thomas.backendtestattronatus.controller;

import com.thomas.backendtestattronatus.model.Address;
import com.thomas.backendtestattronatus.services.AddressService;
import com.thomas.backendtestattronatus.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private PersonService personService;


    @GetMapping("/{id}")
    public ResponseEntity<List<Address>> listAllAddresses (@PathVariable UUID id) {
        return personService.findById(id)
                .map(person -> ResponseEntity.ok(addressService.findAddressByPessoaId(person.getId()))
                ).orElse(ResponseEntity.notFound().build());


    }

    @PostMapping("/{id}/create")
    public ResponseEntity<Address> createAddress (@PathVariable UUID id,
                                                   @RequestBody Address address) {
        return personService.findById(id)
                .map(person -> ResponseEntity
                .ok(addressService.createAddress(address, person)))
                .orElse(ResponseEntity.notFound().build());

    }

    @PatchMapping("/{addressId}/setmain")
    public ResponseEntity<Address> mainAddress (@PathVariable UUID addressId)  {

        return ResponseEntity.ok(addressService.defineMainAddress(addressId));
    }

    @GetMapping("/{id}/main")
    public ResponseEntity<Optional<Address>> getMainAddress (@PathVariable UUID id) {
        return ResponseEntity.ok(addressService.getMainAddress(id));

    }



}
