package com.curso.springboot.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="persons")
public class Person {
	
	@Id
	@Column(name="id_person" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String lastname;
	
	@Column(name = "id_document" )
	private String idDocument;
	
	@Column(name="programming_language")
	private String programmingLanguage;	
	
	public Person() {}

	public Person(Long id, String name, String lastname, String idDocument, String programmingLanguage) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.idDocument = idDocument;
		this.programmingLanguage = programmingLanguage;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(String idDocument) {
		this.idDocument = idDocument;
	}
	public String getProgrammingLanguage() {
		return programmingLanguage;
	}
	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}
	
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", lastname=" + lastname + ", idDocument=" + idDocument
				+ ", programmingLanguage=" + programmingLanguage + "]";
	}

}
