package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@Table(name="clinicalrecord")
@SequenceGenerator(name = "clinicalrecord_id_seq", sequenceName = "clinicalrecord_id_seq")
public class ClinicRecord extends Model{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "clinicalrecord_id_seq", strategy = GenerationType.SEQUENCE)
    public Long	 id;
	
	public Professional professional;
	
	public Intern intern;
	
	public String description;
	
	public static Finder<Long,ClinicRecord> find = new Finder<Long,ClinicRecord>(Long.class, ClinicRecord.class);

}
