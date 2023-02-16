package com.thomas.backendtestattronatus.services;

import com.thomas.backendtestattronatus.model.Address;
import com.thomas.backendtestattronatus.model.Person;
import com.thomas.backendtestattronatus.repository.AddressRepository;
import com.thomas.backendtestattronatus.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Validated
@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PersonRepository personRepository;


    public Address createAddress(Address address, Person person) {

        address.setPerson(person);

        List<Address> addressList = this.findAddressByPessoaId(address.getPerson().getId());

        Address mainAddressFound =
                addressList.stream().filter(addressFound -> addressFound.getMainAddress() == true)
                        .findFirst().orElse(null);

        if (mainAddressFound == null) {

            address.setMainAddress(true);

        }
        return addressRepository.save(address);
    }

    public Optional<Address> findAddressById(UUID id){
        return addressRepository.findById(id);

    }
    public List<Address> findAddressByPessoaId(UUID id){
        Person person = personRepository.findById(id).orElse(null);
        return addressRepository.findAllByPerson(person);

    }

    public Address update(Address address) {

        return addressRepository.save(address);
    }

    public Address defineMainAddress (UUID addressId) {
        Address address = this.findAddressById(addressId).orElse(null);

        List<Address> addressList = this.findAddressByPessoaId(address.getPerson().getId());

        Address changeAddress =
                addressList.stream().filter(addressFound -> addressFound.getMainAddress() == true)
                        .findFirst().orElse(null);

        if (changeAddress != null) {

            changeAddress.setMainAddress(false);
            this.update(changeAddress);

        }

        address.setMainAddress(true);
        return this.update(address);
    }

    public Optional<Address> getMainAddress (UUID id) {

        List<Address> addressList = this.findAddressByPessoaId(id);

         return addressList.stream().filter(addressFound -> addressFound.getMainAddress() == true)
                        .findFirst();
    }




}
