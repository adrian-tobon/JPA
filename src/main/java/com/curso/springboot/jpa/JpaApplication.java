package com.curso.springboot.jpa;

import java.util.List;
import java.util.Optional;
//import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

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
		//findOne();
		//list();
		//create();
		//update();
		delete();
	}
	
	@Transactional
	public void create() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("---- Insercion en la base de datos ----");
		System.out.println("Ingrese nombre: ");
		String name = scanner.next();
		System.out.println("Ingrese apellido: ");
		String lastname = scanner.next();
		System.out.println("Ingrese documento de identidad: ");
		String idDocument = scanner.next();
		System.out.println("Ingrese lenguage de programacion: ");
		String programmingLanguage = scanner.next();
		scanner.close();
		
		Person person = new Person(null, name, lastname, idDocument, programmingLanguage);
		Person newP = personRepository.save(person);
		
		System.out.println(newP);
		
		personRepository.findById(newP.getId()).ifPresent(p -> System.out.println("Insercion exitosa del nuevo "
				+ "usuario con el id " + p.getId()));
		
	}
	
	@Transactional
	public void update() {
		//Person person = new Person(7l, "Carlos", "Tobon", "1128469017", "C#");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("---- Modficacion en la base de datos ----");
		System.out.println("Ingrese id del usuario a modificar: ");
		Long id = scanner.nextLong();
			
		Optional<Person> optionalPerson = personRepository.findById(id);

		optionalPerson.ifPresentOrElse(person -> {
			System.out.println(person);
			System.out.println("Ingrese el lenguaje de programacion ");
			String programmingLanguage = scanner.next();

			person.setProgrammingLanguage(programmingLanguage);

			Person newP = personRepository.save(person);
			System.out.println(newP);
		}, () -> {
			System.out.println("No se encontro el usuario");
		});
		
		scanner.close();
		
	}
	
	
	@Transactional
	public void delete() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("---- Eliminacion en la base de datos ----");
		System.out.println("Ingrese id: ");
		Long id = Long.parseLong(scanner.next());
		scanner.close();
		
		//Person person = personRepository.findById(id).orElseThrow();
		//personRepository.delete(person);
		//personRepository.deleteById(id);
		
		
		Optional<Person> optPerson = personRepository.findById(id);
				
		optPerson.ifPresentOrElse(person -> {
			
			personRepository.delete(person);
			System.out.println("Eliminacion completa");
			
			
		}, () -> {
			System.out.println("No existe en la base de datos");
			} 
		);
		
	}
	
	@Transactional(readOnly = true)
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
