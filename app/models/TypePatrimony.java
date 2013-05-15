package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import play.data.validation.Constraints;
import play.db.jpa.JPA;

/**
 * TypePatrimony entity managed by JPA
 */

@Entity 
@SequenceGenerator(name = "typepatrimony_id_seq", sequenceName = "typepatrimony_id_seq" , allocationSize=1)
public class TypePatrimony extends Model {
	
		@Id
		@Column(name="id")
		@GeneratedValue(generator = "typepatrimony_id_seq")
	    public Long id;
		
		@Constraints.Required
		@Column(name="description")
   	    public String description;
	    
	    /**
	     * Insert this new type of patrimony.
	     */
	    public void save() {
	    	//this.id = id;
	    
	    	//JPA.em().persist(this);
	    	
	    	JPA.em().createNativeQuery("INSERT INTO typePatrimony (description) VALUES (?)").setParameter(1,this.description);
	    	
	    	//JPA.em().persist(this);
	    	
	    }

	    public static TypePatrimony findById(Long id) {
	    	
	        return JPA.em().find(TypePatrimony.class, id);
	        
	    }
	    
	    
	    /**
	     * Return a page of computer
	     *
	     * @param page Page to display
	     * @param pageSize Number of computers per page
	     * @param sortBy Computer property used for sorting
	     * @param order Sort order (either or asc or desc)
	     * @param filter Filter applied on the name column
	     */
	    public static Page page(int page, int pageSize, String sortBy, String order, String filter) {
	        if(page < 1) page = 1;
	        
	        Long total = (Long)JPA.em()
	            .createQuery("SELECT COUNT(tp) FROM TypePatrimony tp WHERE LOWER(tp.description) LIKE ?")
	            .setParameter(1, "%" + filter.toLowerCase() + "%")
	            .getSingleResult();
	        
	        List<TypePatrimony> data = JPA.em()
	            .createQuery("FROM TypePatrimony tp WHERE LOWER(tp.description) LIKE ? ORDER BY tp." + sortBy + " " + order)
	            .setParameter(1, "%" + filter.toLowerCase() + "%")
	            .setFirstResult((page - 1) * pageSize)
	            .setMaxResults(pageSize)
	            .getResultList();
	        
	        return new Page(data, total, page, pageSize);
	    }
	    
	    public static class Page {
	        
	        private final int pageSize;
	        private final long totalRowCount;
	        private final int pageIndex;
	        private final List<TypePatrimony> list;
	        
	        public Page(List<TypePatrimony> data, long total, int page, int pageSize) {
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
	        
	        public List<TypePatrimony> getList() {
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
