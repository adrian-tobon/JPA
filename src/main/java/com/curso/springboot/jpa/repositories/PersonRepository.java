package com.curso.springboot.jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.curso.springboot.jpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{
	
	
	List<Person> findByProgrammingLanguage(String programmingLanguage);	
	
	List<Person> findByProgrammingLanguageAndName(String programmingLanguage,String name);
	
	Optional<Person> findByName(String name);
	
	Optional<Person> findByNameContaining(String name);
	
	Optional<Person> findByNameIgnoreCaseContaining(String name);
	
	@Query("select p from Person p where p.programmingLanguage = ?1")
	List<Person> buscarPorProgrammingLanguage(String programmingLanguage);
	
	@Query("select p.name, p.programmingLanguage from Person p")
	List<Object[]> obtenerPersonData();
	
	@Query("select p from Person p where p.id = ?1")
	Optional<Person> findOne(Long id);
	
	
	@Query("select p from Person p where p.name like %?1%")
	Optional<Person> buscarPorNombreCoincidencia(String pattern);
	
}
