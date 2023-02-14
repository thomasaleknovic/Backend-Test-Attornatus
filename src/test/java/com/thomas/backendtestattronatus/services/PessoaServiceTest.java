//package com.thomas.backendtestattronatus.services;
//
//import com.thomas.backendtestattronatus.PessoaJpaConfig;
//import com.thomas.backendtestattronatus.model.Pessoa;
//import com.thomas.backendtestattronatus.repository.pessoa.PessoaRepository;
//import jakarta.annotation.Resource;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(
//        classes = {PessoaJpaConfig.class},
//        loader = AnnotationConfigContextLoader.class)
//@Transactional
//public class PessoaServiceTest {
//
////    public Pessoa createPessoa (String nome, String dataNascimento) {
////
////        //Create a new Pessoa
////        Pessoa pessoa = new Pessoa();
////        pessoa.setNome(nome);
////
////        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
////        pessoa.setDataNascimento(LocalDate.parse(dataNascimento, formatter));
////
////
////        // Create a new Pessoa in DB
////        return pessoa;
////    }
//
//    @Resource
//    private PessoaService pessoaService;
//    @Resource
//    private PessoaRepository pessoaRepository;
//    @Test
//    public void should_be_able_to_create_a_new_pessoa() {
//        //Create a new Pessoa
//        Pessoa pessoa = new Pessoa();
//        pessoa.setNome("Thomas");
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        pessoa.setDataNascimento(LocalDate.parse("02/09/2000", formatter));
//        Pessoa createdPessoa = pessoaService.create(pessoa);
//
//        assertNotNull(createdPessoa.getId());
//
//    }
//
//
////    @Test
////    public void should_be_able_to_list_all_pessoas() {
////
////        // Instance a repository and the service
////        InMemoryRepository repository = new InMemoryRepository();
////        PessoaService pessoaService = new PessoaService(repository);
////
////        //Create a new Pessoas
////        Pessoa p1 = createPessoa("John Martinez", "15/03/1986");
////        Pessoa p2 = createPessoa("Thomas Aleknovic", "02/02/2000");
////        pessoaService.create(p1);
////        pessoaService.create(p2);
////
////        // List Created Pessoas
////        List<Pessoa> foundPessoas = pessoaService.findAll();
////
////        assertEquals(2, foundPessoas.size());
////
////    }
////
////    @Test
////    public void should_be_able_to_list_one_pessoa_by_its_id() {
////
////        // Instance a repository and the service
////        InMemoryRepository repository = new InMemoryRepository();
////        PessoaService pessoaService = new PessoaService(repository);
////
////
////        //Create a new Pessoa
////        Pessoa p1 = createPessoa("John Martinez", "15/03/1986");
////        Pessoa createdP1  = pessoaService.create(p1);
////
////
////        // Get Created Pessoa
////       Pessoa foundPessoa = pessoaService.findById(createdP1.getId()).orElse(null);
////
////
////        assert foundPessoa != null;
////        assertEquals(createdP1.getId(), foundPessoa.getId());
////
////
////    }
////
////    @Test
////    public void should_be_able_to_list_edit_pessoa_by_its_id() {
////
////        // Instance a repository and the service
////        InMemoryRepository repository = new InMemoryRepository();
////        PessoaService pessoaService = new PessoaService(repository);
////
////
////        //Create a new Pessoa
////        Pessoa p1 = createPessoa("John Martinez", "15/03/1986");
////        Pessoa createdP1  = pessoaService.create(p1);
////
////
////        // Get Created Pessoa
////        Pessoa updatedPessoa = pessoaService.findById(createdP1.getId()).map(pessoa -> {
////            pessoa.setNome("Thomas Aleknovic");
////            pessoa.setDataNascimento(LocalDate.parse("02/09/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
////            return pessoaService.create(pessoa);
////        }).orElse(null);
////
////
////        assert updatedPessoa != null;
////        assertEquals("Thomas Aleknovic", updatedPessoa.getNome());
////
//
////    }
//}
