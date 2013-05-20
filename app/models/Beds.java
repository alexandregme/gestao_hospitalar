package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity 
@SequenceGenerator(name = "bed_id_seq", sequenceName = "bed_id_seq")
@Table(name="bed")
public class Beds extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "bed_id_seq",strategy = GenerationType.SEQUENCE)
	public Long	 id;
		
	
	public String description;
	
	
	public Boolean available;
	
	public static Finder<Long,Beds> find = new Finder<Long,Beds>(Long.class, Beds.class);
	
}
