create DATABASE db_springboot;

--use db_springboot;

create table db_springboot.persons(
    id_person bigint AUTO_INCREMENT,
	name varchar(255),
    lastname varchar(255),    
	id_document varchar(255),
    programming_language varchar(255), 
	primary key(id_person)
   
);

INSERT INTO db_springboot.persons (name, lastname, id_document, programming_language) VALUES ('Andres', 'Guzman', '2516156464' ,'Java');
INSERT INTO db_springboot.persons (name, lastname, id_document, programming_language) VALUES ('Pepe', 'Doe', '5464565461' ,'Python');
INSERT INTO db_springboot.persons (name, lastname, id_document, programming_language) VALUES ('John', 'Dow', '2467946545' ,'JavaScript');
INSERT INTO db_springboot.persons (name, lastname, id_document, programming_language) VALUES ('Maria', 'Roe', '1363845469' ,'Java');
INSERT INTO db_springboot.persons (name, lastname, id_document, programming_language) VALUES ('Josefa', 'Rae', '9874624615' ,'Java');

