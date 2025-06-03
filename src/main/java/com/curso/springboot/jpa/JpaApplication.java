package com.curso.springboot.jpa;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.springboot.jpa.entities.Person;
import com.curso.springboot.jpa.repositories.PersonRepository;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
	
	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		findOne();
	
	}
	
	public void findOne() {
		//Person person = personRepository.findById(2l).orElseThrow();
		/*Person person = null;
		Optional<Person> optional = personRepository.findById(8l);
		if(optional.isPresent()) {
			person = optional.get();
			System.out.println(person);
		}else {
			System.out.println("la persona no se encuentra en la base de datos");
		}*/
			
		//personRepository.findById(8l).ifPresent(person -> System.out.println(person));
		//personRepository.findById(8l).ifPresent(System.out::println);
		personRepository.findOne(2l).ifPresent(System.out::println);
		personRepository.findByName("Andres").ifPresent(System.out::println);
		personRepository.findByNameContaining("se").ifPresent(System.out::println);
		personRepository.findByNameIgnoreCaseContaining("an").ifPresent(System.out::println);
		personRepository.buscarPorNombreCoincidencia("ri").ifPresent(System.out::println);
		
	}
	
	
	public void list() {
		
		//List<Person> persons = (List<Person>)personRepository.findAll();
		//List<Person> persons = (List<Person>)personRepository.findByProgrammingLanguage("Java");
		List<Person> persons = (List<Person>)personRepository.findByProgrammingLanguageAndName("Java","Andres");
		//List<Person> persons = (List<Person>)personRepository.buscarPorProgrammingLanguage("Java");
				
		persons.stream().forEach(person -> System.out.println(person));		
		
		List<Object[]> personsValues = personRepository.obtenerPersonData();
		
		personsValues.stream().forEach(person -> {
			System.out.println(person[0] + " es experto en " + person[1]);			

		});		
	}
}
