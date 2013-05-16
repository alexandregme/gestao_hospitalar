package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.jpa.JPA;

/**
 * Doctor entity managed by JPA
 */

@Entity 
@SequenceGenerator(name = "doctor_seq", sequenceName = "doctor_seq")
public class Doctor{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_seq")
    public Long id;
    
    @Constraints.Required
    public String name;
    
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date introduced;
    
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date discontinued;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    public Company company;
    
    /**
     * Find a company by id.
     */
    public static Doctor findById(Long id) {
        return JPA.em().find(Doctor.class, id);
    }
    
    /**
     * Update this Doctor.
     */
    public void update(Long id) {
        if(this.company.id == null) {
            this.company = null;
        } else {
            this.company = Company.findById(company.id);
        }
        this.id = id;
        JPA.em().merge(this);
    }
    
    /**
     * Insert this new doctor.
     */
    public void save() {
    	
        if(this.company.id == null) {
        	
            this.company = null;
            
        } else {
        	
            this.company = Company.findById(company.id);
        }
        
        this.id = id;
        
        JPA.em().persist(this);
        
    }

    /**
     * Delete this doctor.
     */
    public void delete() {
        JPA.em().remove(this);
    }
    
    /**
     * Return a page of Doctor
     *
     * @param page Page to display
     * @param pageSize Number of doctors per page
     * @param sortBy Doctor property used for sorting
     * @param order Sort order (either or asc or desc)
     * @param filter Filter applied on the name column
     */
    public static Page page(int page, int pageSize, String sortBy, String order, String filter) {
    
    	if(page < 1) page = 1;
        
    	Long total = (Long)JPA.em()
        
    			.createQuery("select count(c) from medico c where lower(c.name) like ?")
            
    			.setParameter(1, "%" + filter.toLowerCase() + "%")
            
    			.getSingleResult();
        
    	List<Doctor> data =  JPA.em()
        
    			.createQuery("from medico c where lower(c.name) like ? order by c." + sortBy + " " + order)
            
    			.setParameter(1, "%" + filter.toLowerCase() + "%")
            
    			.setFirstResult((page - 1) * pageSize)
            
    			.setMaxResults(pageSize)
            
    			.getResultList();
        
    	return new Page(data, total, page, pageSize);
    	
    }
    
    /**
     * Used to represent a doctors page.
     */
    public static class Page {
        
        private final int pageSize;
        
        private final long totalRowCount;
        
        private final int pageIndex;
        
        private final List<Doctor> list;
        
        public Page(List<Doctor> data, long total, int page, int pageSize) {
        	
            this.list = data;
            
            this.totalRowCount = total;
            
            this.pageIndex = page;
            
            this.pageSize = pageSize;

        }
        
        public long getTotalRowCount() {
        	
            return totalRowCount;
            
        }
        
        public int getPageIndex() {
        	
            return pageIndex;
            
        }
        
        public List<Doctor> getList() {
        	
            return list;
            
        }
        
        public boolean hasPrev() {
        	
            return pageIndex > 1;
            
        }
        
        public boolean hasNext() {
        	
            return (totalRowCount/pageSize) >= pageIndex;
            
        }
        
        public String getDisplayXtoYofZ() {
        	
            int start = ((pageIndex - 1) * pageSize + 1);
            
            int end = start + Math.min(pageSize, list.size()) - 1;
            
            return start + " to " + end + " of " + totalRowCount;
            
        }
        
    }
    
}
