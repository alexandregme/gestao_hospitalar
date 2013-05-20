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

@Entity 
@SequenceGenerator(name = "authorizations_id_seq", sequenceName = "authorizations_id_seq")
@Table(name="authorizations")
public class Authorizations extends Model{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "authorizations_id_seq",strategy = GenerationType.SEQUENCE)
	public Long	 id;
	
	@ManyToOne
	@Column(name = "typeexamination")
	public TypeExaminations typeexamination;
	
	@ManyToOne
	@Column(name = "covenant")
	public Covenants covenant;
	
	public static Finder<Long,Authorizations> find = new Finder<Long,Authorizations>(Long.class, Authorizations.class);
	
}
