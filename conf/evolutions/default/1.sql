# --- First database schema

# --- !Ups

create table patrimonies (
  id                        SERIAL primary key,
  description                      varchar(255))
;

create table typeexaminations (  
	id                        SERIAL primary key,
  	description                      varchar(255))
;

create table covenants (  
	id                        SERIAL primary key,
  	description                      varchar(255))
;

--- agreements  between covenant and types of medical examinations
create table authorizations	(  
	id                  SERIAL primary key,
	covenant_id      		integer references covenants(id),
 	typeexamination_id	integer references typeexaminations(id))
;

create table professional (
  	id              SERIAL primary key,
  	name            varchar(255),
 	document       varchar(255),
 	typeexamination_id	integer references typeexaminations(id))
;

create table bed (  
	id                        SERIAL primary key,
  	description                      varchar(255),
  	available					boolean)
;

create table patient (
  	id              SERIAL primary key,
  	name            varchar(255),
 	cpf				varchar(255),
 	endereco    	varchar(255))
;


create table intern (
  	id              SERIAL primary key,
  	released boolean,
 	bed_id	integer references bed(id),
 	patient_id integer references patient(id))
;

create table clinicalrecord (
  	id              SERIAL primary key,
 	professional_id	integer references professional(id),
 	intern_id	integer references intern(id),
 	description    	varchar(255))
;