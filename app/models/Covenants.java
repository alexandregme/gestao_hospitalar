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
@Table(name="covenants")
@SequenceGenerator(name = "covenants_id_seq", sequenceName = "covenants_id_seq")
public class Covenants extends Model{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "covenants_id_seq", strategy = GenerationType.SEQUENCE)
    public Long	 id;
	
	@Column(name = "description")
	public String description;
	
	public static Finder<Long,Covenants> find = new Finder<Long,Covenants>(Long.class, Covenants.class);

}
