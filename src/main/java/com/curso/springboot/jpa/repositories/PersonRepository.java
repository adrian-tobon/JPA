package com.curso.springboot.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.curso.springboot.jpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{
	
	
	List<Person> findByProgrammingLanguage(String programmingLanguage);	
	
	List<Person> findByProgrammingLanguageAndName(String programmingLanguage,String name);	
	
	@Query("select p from Person p where p.programmingLanguage = ?1")
	List<Person> buscarPorProgrammingLanguage(String programmingLanguage);

}
