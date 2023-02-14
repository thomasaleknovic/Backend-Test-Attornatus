//package com.thomas.backendtestattronatus.services;
//
//import com.thomas.backendtestattronatus.model.Endereco;
//import com.thomas.backendtestattronatus.model.Pessoa;
//
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class EnderecoServiceTest {
//
//    public Pessoa createPessoa (String nome, String dataNascimento) {
//
//        //Create a new Pessoa
//        Pessoa pessoa = new Pessoa();
//        pessoa.setNome(nome);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        pessoa.setDataNascimento(LocalDate.parse(dataNascimento, formatter));
//
//
//        // Create a new Pessoa in DB
//        return pessoa;
//    }
//
//
//    @Test
//    public void should_be_able_to_add_a_endereco_to_pessoa_by_its_id() {
//
//        // Instance a repository and the service
//        InMemoryRepository repository = new InMemoryRepository();
//        PessoaService pessoaService = new PessoaService(repository);
//        EnderecoService enderecoService = new EnderecoService(repository);
//
//
//        //Create a new Pessoa
//        Pessoa p1 = createPessoa("John Martinez", "15/03/1986");
//        Pessoa createdP1  = pessoaService.create(p1);
//
//
//        // Create Endereco
//        Endereco createdEndereco = pessoaService.findById(createdP1.getId()).map(pessoa -> {
//            Endereco endereco = new Endereco();
//            endereco.setPessoa(pessoa);
//            endereco.setCep("91130-465");
//            endereco.setCidade("Porto Alegre");
//            endereco.setNumero("1234");
//            endereco.setLogradouro("Rua um de oliveira");
//            return enderecoService.create(endereco);
//        }).orElse(null);
//
//
////        assert createdEndereco != null;
////        System.out.println(createdEndereco.getPessoa());
////        System.out.println(createdEndereco.getLogradouro());
////        System.out.println(createdEndereco.getCep());
//
//        assertEquals("Porto Alegre", createdEndereco.getCidade());
//
//    }
//}
