package com.thomas.backendtestattronatus.repository;

import com.thomas.backendtestattronatus.model.Address;
import com.thomas.backendtestattronatus.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AddressRepository extends JpaRepository <Address, UUID> {
    List<Address> findAllByPerson(Person person);
}
