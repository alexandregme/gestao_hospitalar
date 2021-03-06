# --- Sample dataset

# --- !Ups

insert into typeexaminations (id,description) values (1,'Anestesiologia');
insert into typeexaminations (id,description) values (2,'Cardiologista');
insert into typeexaminations (id,description) values (3,'Dermatologia‎');
insert into typeexaminations (id,description) values (4,'Endocrinologia‎');
insert into typeexaminations (id,description) values (5,'Gerontologia‎');
insert into typeexaminations (id,description) values (6,'Hematologia‎');
insert into typeexaminations (id,description) values (7,'Infectologia‎');
insert into typeexaminations (id,description) values (8,'Mastologia‎');
insert into typeexaminations (id,description) values (9,'Neurologia‎');
insert into typeexaminations (id,description) values (10,'Oftalmologia‎');
insert into typeexaminations (id,description) values (11,'Pediatria');
insert into typeexaminations (id,description) values (12,'Reabilitação');
insert into typeexaminations (id,description) values (13,'Medicina do sono');
insert into typeexaminations (id,description) values (14,'Traumatologia‎');

insert into covenants (id,description) values (1,'ALLIANZ SAÚDE S/A');
insert into covenants (id,description) values (2,'BARDELLA S/A INDÚSTRIAS MECÂNICAS');
insert into covenants (id,description) values (3,'CAIXA ECONÔMICA FEDERAL');
insert into covenants (id,description) values (4,'CLINIPREV SAÚDE LTDA');
insert into covenants (id,description) values (5,'MS ASSISTÊNCIA MÉDICA S/C LTDA');
insert into covenants (id,description) values (6,'SOCIEDADE PORTUGUESA DE BENEFICÊNCIA');
insert into covenants (id,description) values (7,'UNIMED');

insert into authorizations (covenant_id,typeexamination_id) values (1,2);
insert into authorizations (covenant_id,typeexamination_id) values (1,3);
insert into authorizations (covenant_id,typeexamination_id) values (1,5);
insert into authorizations (covenant_id,typeexamination_id) values (1,6);
insert into authorizations (covenant_id,typeexamination_id) values (1,7);
insert into authorizations (covenant_id,typeexamination_id) values (1,10);
insert into authorizations (covenant_id,typeexamination_id) values (1,11);
insert into authorizations (covenant_id,typeexamination_id) values (2,1);
insert into authorizations (covenant_id,typeexamination_id) values (2,2);
insert into authorizations (covenant_id,typeexamination_id) values (2,3);
insert into authorizations (covenant_id,typeexamination_id) values (2,7);
insert into authorizations (covenant_id,typeexamination_id) values (2,8);
insert into authorizations (covenant_id,typeexamination_id) values (2,9);
insert into authorizations (covenant_id,typeexamination_id) values (2,10);
insert into authorizations (covenant_id,typeexamination_id) values (2,11);
insert into authorizations (covenant_id,typeexamination_id) values (3,5);
insert into authorizations (covenant_id,typeexamination_id) values (3,7);
insert into authorizations (covenant_id,typeexamination_id) values (3,8);
insert into authorizations (covenant_id,typeexamination_id) values (3,9);
insert into authorizations (covenant_id,typeexamination_id) values (3,10);
insert into authorizations (covenant_id,typeexamination_id) values (3,11);
insert into authorizations (covenant_id,typeexamination_id) values (3,12);
insert into authorizations (covenant_id,typeexamination_id) values (3,13);
insert into authorizations (covenant_id,typeexamination_id) values (3,14);
insert into authorizations (covenant_id,typeexamination_id) values (4,1);
insert into authorizations (covenant_id,typeexamination_id) values (4,2);
insert into authorizations (covenant_id,typeexamination_id) values (4,3);
insert into authorizations (covenant_id,typeexamination_id) values (5,4);
insert into authorizations (covenant_id,typeexamination_id) values (5,5);
insert into authorizations (covenant_id,typeexamination_id) values (5,6);
insert into authorizations (covenant_id,typeexamination_id) values (6,7);
insert into authorizations (covenant_id,typeexamination_id) values (6,8);
insert into authorizations (covenant_id,typeexamination_id) values (6,9);
insert into authorizations (covenant_id,typeexamination_id) values (6,10);
insert into authorizations (covenant_id,typeexamination_id) values (7,11);
insert into authorizations (covenant_id,typeexamination_id) values (7,12);
insert into authorizations (covenant_id,typeexamination_id) values (7,13);
insert into authorizations (covenant_id,typeexamination_id) values (7,14);

insert into bed (id,description,available) values (1,'Leito 1',true);
insert into bed (id,description,available) values (2,'Leito 2',true);
insert into bed (id,description,available) values (3,'Leito 3',true);
insert into bed (id,description,available) values (4,'Leito 4',true);
insert into bed (id,description,available) values (5,'Leito 5',true);
insert into bed (id,description,available) values (6,'Leito 6',true);
insert into bed (id,description,available) values (7,'Leito 7',true);
insert into bed (id,description,available) values (8,'Leito 8',true);
insert into bed (id,description,available) values (9,'Leito 9',true);
insert into bed (id,description,available) values (10,'Leito 10',true);
insert into bed (id,description,available) values (11,'Leito 11',true);