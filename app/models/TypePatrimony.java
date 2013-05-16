package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import play.data.validation.Constraints;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

/**
 * TypePatrimony entity managed by Ebean
 */

@Entity 
@SequenceGenerator(name = "typepatrimony_id_seq", sequenceName = "typepatrimony_id_seq")
@Table(name="typepatrimony")
public class TypePatrimony extends Model {
	
		@Id
		@GeneratedValue(generator = "typepatrimony_id_seq",strategy = GenerationType.SEQUENCE)
	    public Long	 id;
		
		@Constraints.Required
		public String description;
		
		public static Finder<Long,TypePatrimony> find = new Finder<Long,TypePatrimony>(Long.class, TypePatrimony.class);
}
