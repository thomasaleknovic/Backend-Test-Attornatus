package com.thomas.backendtestattronatus;

import com.thomas.backendtestattronatus.repository.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendTestAttronatusApplication {


	public static void main(String[] args) {
		SpringApplication.run(BackendTestAttronatusApplication.class, args);
	}

}
