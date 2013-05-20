package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * TypePatrimony entity managed by Ebean
 */

@Entity 
@SequenceGenerator(name = "patrimonies_id_seq", sequenceName = "patrimonies_id_seq")
@Table(name="patrimonies")
public class Patrimonies extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "patrimonies_id_seq",strategy = GenerationType.SEQUENCE)
	public Long	 id;
		
	@Constraints.Required
	public String description;
	
	public static Finder<Long,Patrimonies> find = new Finder<Long,Patrimonies>(Long.class, Patrimonies.class);
	
}
