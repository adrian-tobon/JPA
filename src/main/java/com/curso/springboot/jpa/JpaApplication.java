package com.curso.springboot.jpa;

import java.util.List;

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
		
		//List<Person> persons = (List<Person>)personRepository.findAll();
		//List<Person> persons = (List<Person>)personRepository.findByProgrammingLanguage("Java");
		List<Person> persons = (List<Person>)personRepository.findByProgrammingLanguageAndName("Java","Andres");
		//List<Person> persons = (List<Person>)personRepository.buscarPorProgrammingLanguage("Java");
		
		persons.stream().forEach(person -> System.out.println(person));
		
	}

}
