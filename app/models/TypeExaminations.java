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
@Table(name="typeexaminations")
@SequenceGenerator(name = "typeexaminations_id_seq", sequenceName = "typeexaminations_id_seq")
public class TypeExaminations extends Model{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "typeexaminations_id_seq", strategy = GenerationType.SEQUENCE)
    public Long	 id;
	
	@Column(name = "description")
	public String description;
	
	public static Finder<Long,TypeExaminations> find = new Finder<Long,TypeExaminations>(Long.class, TypeExaminations.class);

}
