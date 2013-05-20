package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity 
@SequenceGenerator(name = "patient_id_seq", sequenceName = "patient_id_seq")
@Table(name="patient")

public class Patient extends Model {
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(generator = "patient_id_seq", strategy = GenerationType.SEQUENCE)
	public Long id;

	@Column(name = "name")
	public String name;
	
	@Column(name = "cpf")
	public String cpf;
	
	@Column(name = "endereco")
	public String endereco;

	public static Finder<Long,Patient> find = new Finder<Long,Patient>(Long.class, Patient.class);

}
