package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@SequenceGenerator(name = "intern_id_seq", sequenceName = "intern_id_seq")
@Table(name="intern")
public class Intern extends Model{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "intern_id_seq",strategy = GenerationType.SEQUENCE)
	public Long	 id;
	
	@ManyToOne
	@Column(name = "bed")
	public Beds bed;
	
	@ManyToOne
	@Column(name = "patient")
	public Patient patient;
	
	public static Finder<Long,Authorizations> find = new Finder<Long,Authorizations>(Long.class, Authorizations.class);
	
}
