package com.thomas.backendtestattronatus;

import com.thomas.backendtestattronatus.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TestH2Repository extends JpaRepository<Person, UUID> {
}
