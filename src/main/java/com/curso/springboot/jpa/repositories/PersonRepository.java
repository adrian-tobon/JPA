package com.curso.springboot.jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.curso.springboot.jpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{

}
