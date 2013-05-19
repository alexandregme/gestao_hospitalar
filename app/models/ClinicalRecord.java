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
@Table(name="clinicalrecord")
@SequenceGenerator(name = "clinicalrecord_id_seq", sequenceName = "clinicalrecord_id_seq")
public class ClinicalRecord extends Model{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "clinicalrecord_id_seq", strategy = GenerationType.SEQUENCE)
    public Long	 id;
	
	@ManyToOne
	@Column(name = "professional")
	public Professional professional;
	
	@ManyToOne
	@Column(name = "intern")
	public Intern intern;
	
	public String description;
	
	public static Finder<Long,ClinicalRecord> find = new Finder<Long,ClinicalRecord>(Long.class, ClinicalRecord.class);

}
