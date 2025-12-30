package com.curso.springboot.jpa;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
//import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.curso.springboot.jpa.dto.PersonDTO;
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
		// findOne();
		// list();
		// create();
		// update();
		// delete();
		// personalizedQueries();
		 personalizedQueries2();
	}

	@Transactional(readOnly = true)
	public void personalizedQueries() {

		/*System.out.println("-----------Full informacion-------------");
		List<Object[]> fulldata = personRepository.obtenerFullPersonData();

		fulldata.stream().forEach(p -> {
			System.out.println("--------------");
			System.out.println(p[0]);
			System.out.println(p[1]);
			System.out.println(p[2]);
			System.out.println(p[3]);
			System.out.println(p[4]);
			System.out.println("--------------");

		});*/

		/*Scanner scanner = new Scanner(System.in);
		System.out.println("---------------Inserte el id----------------");
		Long id = scanner.nextLong();
		*/
		
		/*Object[] fulldataId = (Object[])personRepository.obtenerFullPersonDataById(id);

		System.out.println("id = " + fulldataId[0] + " nombre = " + fulldataId[1] + " apellido = " 
				+ fulldataId[2] + " Cedula = " + fulldataId[3] + " Lenguaje = " + fulldataId[4]);
		 */
		
		/*Optional<Object> fulldataOptional = personRepository.obtenerFullPersonDataById(id);
		
		if(fulldataOptional.isPresent())
		{
			Object[] fulldataId = (Object[])fulldataOptional.orElseThrow();
			System.out.println("id = " + fulldataId[0] + " nombre = " + fulldataId[1] + " apellido = " 
					+ fulldataId[2] + " Cedula = " + fulldataId[3] + " Lenguaje = " + fulldataId[4]);
			
		}	*/	
		
		/*
		 * String fullName = personRepository.getFullNameById(id);
		 * System.out.println("Su nombre es: " + fullName);
		 */ 
		
		 /* System.out.println("---------------Inserte el name----------------"); String
		 * name2 = scanner.next();
		 * 
		 * Long id2 = personRepository.getId(name2);
		 * System.out.println("Su nombre es: "+id2);
		 */
		
		/*List<Object[]> personRegs = personRepository.findAllMixPerson();
		
		personRegs.forEach(reg -> {
			
			System.out.println(reg[0]);
			System.out.println(reg[1]);
			
		});
		*/
		
		/*List<Person> personRegs = personRepository.findAllPersonalizedPerson();
		
		personRegs.forEach(reg -> {
			System.out.println(reg.getName());
			System.out.println(reg.getLastname());
			
		});*/
		
		/*List<PersonDTO> personRegs = personRepository.findAllPersonalizedDTOPerson();
		
		personRegs.forEach(reg -> {
			System.out.println(reg.getName());
			System.out.println(reg.getLastname());
			
		});*/
		
		/*List<String> names = personRepository.findAllNames();
		names.forEach(System.out::println);*/
		
		List<String> DistinctNames = personRepository.findAllDistinctNames();
		DistinctNames.forEach(System.out::println);
		
		
		List<String> DistinctPL = personRepository.findAllDistinctProgrammingLanguages();
		DistinctPL.forEach(System.out::println);
		
		
		System.out.println("numero de lenguajes: " + personRepository.findAllDistinctProgrammingLanguagesCount());
		//scanner.close();

	}
	
	@Transactional(readOnly = true)
	public void personalizedQueries2() {
		
		/*List<String> fullNames = personRepository.findAllFullNames();
		fullNames.forEach(System.out::println);
		
		List<String> lowerNames = personRepository.findAllLowerNames();
		lowerNames.forEach(System.out::println);
		
		List<String> upperNames = personRepository.findAllUpperNames();
		upperNames.forEach(System.out::println);*/
		
		/*Scanner scanner = new Scanner(System.in);
		System.out.println("---- busqueda entre dos ids ----");
		System.out.println("Ingrese id inical: ");
		Long x1  = scanner.nextLong();
		System.out.println("Ingrese id final: ");
		Long x2  = scanner.nextLong();
		
		//List<Person> listPerson = personRepository.buscarPorRangoId(x1, x2);
		List<Person> listPerson = personRepository.findByIdBetween(x1, x2);
		listPerson.forEach(p -> {
			System.out.println(p.toString());			
		});	*/
		
				
		/*Scanner scanner = new Scanner(System.in);
		System.out.println("---- busqueda nombre entre dos letras ----");
		System.out.println("Ingrese letra inical: ");
		String start  = scanner.next();
		System.out.println("Ingrese letra final: ");
		String end = scanner.next();
		
		List<Person> listPerson = personRepository.buscarPorRangoName(start,end);
		//List<Person> listPerson = personRepository.findByNameBetweenOrderByNameDescLastnameAsc(start,end);
		listPerson.forEach(p -> {
			System.out.println(p);			
		});
		
		
		scanner.close();*/
		
		//List<Person> persons = personRepository.getAllPersonOrdered();
		/*List<Person> persons = personRepository.findAllByOrderByNameAscLastnameAsc();
		persons.forEach(System.out::println);*/
		
		//Long count = personRepository.count();
		Long count = personRepository.getPersonsCount();
		Long max = personRepository.getMaxId();
		Long min = personRepository.getMinId();
		Long sum = personRepository.getSumId();
		Long avg = personRepository.getAvgId();
		
		
		System.out.println(count + " registro(s)");
		System.out.println("maximo id: " + max);
		System.out.println("minimo id: " + min);
		System.out.println("sum id: " + sum);
		System.out.println("avg id: " + avg);
		
		
		List<Object[]> personNamesLength = personRepository.getPersonNameLength();
		personNamesLength.forEach(pnl ->{
			System.out.println(pnl[0] + " " + pnl[1]);			
		});
		
		
		List<Object[]> minNameLength = personRepository.getMinNameLength();
		minNameLength.forEach(values ->{
			System.out.println("El nombre mas corto es: " + values[0] + " con " + values[1] + " caracteres");
		});
		
		
		List<Object[]> maxNameLength = personRepository.getMaxNameLength();
		maxNameLength.forEach(values ->{
			System.out.println("El nombre mas corto es: " + values[0] + " con " + values[1] + " caracteres");
		});
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

		personRepository.findById(newP.getId())
				.ifPresent(p -> System.out.println("Insercion exitosa del nuevo " + "usuario con el id " + p.getId()));

	}

	@Transactional
	public void update() {
		// Person person = new Person(7l, "Carlos", "Tobon", "1128469017", "C#");

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

		// Person person = personRepository.findById(id).orElseThrow();
		// personRepository.delete(person);
		// personRepository.deleteById(id);

		Optional<Person> optPerson = personRepository.findById(id);

		optPerson.ifPresentOrElse(person -> {

			personRepository.delete(person);
			System.out.println("Eliminacion completa");

		}, () -> {
			System.out.println("No existe en la base de datos");
		});

	}

	@Transactional(readOnly = true)
	public void findOne() {
		// Person person = personRepository.findById(2l).orElseThrow();
		/*
		 * Person person = null; 
		 * Optional<Person> optional = personRepository.findById(8l); 
		 * if(optional.isPresent()) { 
		 * 		person =  optional.get(); 
		 * 		System.out.println(person); 
		 * }else {
		 * System.out.println("la persona no se encuentra en la base de datos"); 
		 * }
		 */

		// personRepository.findById(8l).ifPresent(person ->
		// System.out.println(person));
		// personRepository.findById(8l).ifPresent(System.out::println);
		personRepository.findOne(2l).ifPresent(System.out::println);
		personRepository.findByName("Andres").ifPresent(System.out::println);
		personRepository.findByNameContaining("se").ifPresent(System.out::println);
		personRepository.findByNameIgnoreCaseContaining("an").ifPresent(System.out::println);
		personRepository.buscarPorNombreCoincidencia("ri").ifPresent(System.out::println);

	}

	public void list() {

		// List<Person> persons = (List<Person>)personRepository.findAll();
		// List<Person> persons =
		// (List<Person>)personRepository.findByProgrammingLanguage("Java");
		List<Person> persons = (List<Person>) personRepository.findByProgrammingLanguageAndName("Java", "Andres");
		// List<Person> persons =
		// (List<Person>)personRepository.buscarPorProgrammingLanguage("Java");

		persons.stream().forEach(person -> System.out.println(person));

		List<Object[]> personsValues = personRepository.obtenerPersonData();

		personsValues.stream().forEach(person -> {
			System.out.println(person[0] + " es experto en " + person[1]);

		});
	}
}
