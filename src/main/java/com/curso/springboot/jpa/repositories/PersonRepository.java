package com.curso.springboot.jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.curso.springboot.jpa.entities.Person;
import com.curso.springboot.jpa.dto.PersonDTO;

public interface PersonRepository extends CrudRepository<Person, Long>{
	
	
	@Query("select p from Person p where p.id in ?1")
	List<Person> getPersonByIds(List<Long> ids);
	
	@Query("select p from Person p where p.id not in ?1")
	List<Person> getPersonNotInIds(List<Long> ids);
	
	@Query("select p.name, length(p.name) from Person p where length(p.name)=(select min(length(p.name)) from Person p)")
	List<Object[]> getShorterName();
	
	@Query("select p.name, length(p.name) from Person p where length(p.name)=(select max(length(p.name)) from Person p)")
	List<Object[]> getLongerName();	
	
	
	@Query("select p.name, length(p.name) from Person p order by length(p.name) asc fetch first 1 row only")
	List<Object[]> getMinNameLength();
	
	@Query("select p.name, length(p.name) from Person p order by length(p.name) desc fetch first 1 row only")
	List<Object[]> getMaxNameLength();
	
	@Query("select p.name,length(p.name) from Person p")
	List<Object[]> getPersonNameLength();
	
	@Query("select count(p) from Person p")
	Long getPersonsCount();
	
	@Query("select p from Person p order by p.name,p.lastname")
	List<Person> getAllPersonOrdered();
	
	@Query("select max(p.id) from Person p")
	Long getMaxId();
	
	@Query("select min(p.id) from Person p")
	Long getMinId();
	
	@Query("select sum(p.id) from Person p")
	Long getSumId();
	
	@Query("select avg(p.id) from Person p")
	Long getAvgId();
	
	List<Person> findAllByOrderByNameAscLastnameAsc();
	
	List<Person> findByIdBetween(Long x1,Long x2);
	
	List<Person> findByNameBetweenOrderByNameDescLastnameAsc(String start,String end);
	
	@Query("select p from Person p where p.name between ?1 and ?2 order by p.name desc, p.lastname asc")
	List<Person> buscarPorRangoName(String start,String end);
	
	@Query("select p from Person p where p.id between ?1 and ?2")
	List<Person> buscarPorRangoId(Long x1,Long x2);
		
	//@Query("select concat(p.name,' ',p.lastname) as fullname from Person p")
	@Query("select p.name||' '||p.lastname as fullname from Person p")
	List<String> findAllFullNames();
		
	@Query("select lower(concat(p.name,' ',p.lastname)) as fullname from Person p")
	List<String> findAllLowerNames();
	
	@Query("select upper(concat(p.name,' ',p.lastname)) as fullname from Person p")
	List<String> findAllUpperNames();
	
	@Query("select p.name from Person p")
	List<String> findAllNames();
	
	@Query("select distinct(p.name) from Person p")
	List<String> findAllDistinctNames();
	
	@Query("select distinct(p.programmingLanguage) from Person p")
	List<String> findAllDistinctProgrammingLanguages();
	
	@Query("select count(distinct(p.programmingLanguage)) from Person p")
	Long findAllDistinctProgrammingLanguagesCount();
	
	@Query("select new com.curso.springboot.jpa.dto.PersonDTO(p.name,p.lastname) from Person p")
	List<PersonDTO> findAllPersonalizedDTOPerson();	
			
	@Query("select new Person(p.name,p.lastname) from Person p")
	List<Person> findAllPersonalizedPerson();
	
	@Query("select p.name from Person p where p.id = ?1")
	String getNameById(Long id);
	
	@Query("select p.id from Person p where p.name = ?1")
	Long getId(String name);
	
	
	@Query("select concat(p.name,' ',p.lastname) as fullname from Person p where p.id = ?1")
	String getFullNameById(Long id);
	
	List<Person> findByProgrammingLanguage(String programmingLanguage);	
	
	List<Person> findByProgrammingLanguageAndName(String programmingLanguage,String name);
	
	Optional<Person> findByName(String name);
	
	Optional<Person> findByNameContaining(String name);
	
	Optional<Person> findByNameIgnoreCaseContaining(String name);
	
	@Query("select p from Person p where p.programmingLanguage = ?1")
	List<Person> buscarPorProgrammingLanguage(String programmingLanguage);
	
	@Query("select p.id, p.name, p.lastname, p.idDocument, p.programmingLanguage from Person p")
	List<Object[]> obtenerFullPersonData();
	
	@Query("select p, p.programmingLanguage from Person p")
	List<Object[]> findAllMixPerson();
	
	@Query("select p.id, p.name, p.lastname, p.idDocument, p.programmingLanguage from Person p where p.id = ?1")
	Optional<Object> obtenerFullPersonDataById(Long id);
	
	@Query("select p.name, p.programmingLanguage from Person p")
	List<Object[]> obtenerPersonData();
	
	@Query("select p from Person p where p.id = ?1")
	Optional<Person> findOne(Long id);
	
	
	@Query("select p from Person p where p.name like %?1%")
	Optional<Person> buscarPorNombreCoincidencia(String pattern);
	
}
