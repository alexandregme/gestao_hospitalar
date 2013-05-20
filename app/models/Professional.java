
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
@SequenceGenerator(name = "professional_id_seq", sequenceName = "professional_id_seq")
@Table(name="professional")

public class Professional extends Model {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "professional_id_seq", strategy = GenerationType.SEQUENCE)
	public Long id;

	@Column(name = "name")
	public String name;

	@Column(name = "document")
	public String document;
	
	@ManyToOne
	@Column(name = "typeexamination")
	public TypeExaminations typeexamination;
	
	public static Finder<Long,Professional> find = new Finder<Long,Professional>(Long.class, Professional.class);
	
	
}