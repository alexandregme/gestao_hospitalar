# --- First database schema

# --- !Ups

create sequence typePatrimony_seq start with 1000;
create table typePatrimony(
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_typePatrimony primary key (id))
;

create sequence patrimony_seq start with 1000;
create table patrimony (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_patrimony primary key (id))
;

create sequence patients_seq start with 1000;
create table patients(
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_patients primary key (id))
;

create sequence financial_seq start with 1000;
create table financial(
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_financial primary key (id))
;

create sequence healthInsurance_seq start with 1000;
create table healthInsurance(
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_healthInsurance primary key (id))
;

create sequence doctor_seq start with 1000;
create table doctor (
  id                        bigint not null,  
  name                      varchar(255),
  constraint pk_doctor primary key (id))
;



create table company (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_company primary key (id))
;

create table computer (
  id                        bigint not null,
  name                      varchar(255),
  introduced                timestamp,
  discontinued              timestamp,
  company_id                bigint,
  constraint pk_computer primary key (id))
;


create table teste (
  id                        bigint not null,
  name                      varchar(255),
  introduced                timestamp,
  discontinued              timestamp,
  company_id                bigint,
  constraint pk_computer primary key (id))
;

create sequence company_seq start with 1000;

create sequence computer_seq start with 1000;

alter table computer add constraint fk_computer_company_1 foreign key (company_id) references company (id) on delete restrict on update restrict;
create index ix_computer_company_1 on computer (company_id);


# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists company;

drop table if exists computer;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists company_seq;

drop sequence if exists computer_seq;

