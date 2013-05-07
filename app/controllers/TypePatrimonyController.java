package controllers;

import static play.data.Form.form;
import models.Computer;
import models.TypePatrimony;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.createForm;
import views.html.doctor;
import views.html.editForm;
import views.html.typePatrimony;

public class TypePatrimonyController extends Controller  {
	
	 public static Result GO_HOME = redirect(routes.Application.view());
	 
    /**
     * Handle default path requests, redirect to doctors list
     */
	 public static Result save() {
		  
		  Form<TypePatrimony> typePatrimonyForm = form(TypePatrimony.class).bindFromRequest();
		  
		  if(typePatrimonyForm.hasErrors()) {
		      return badRequest(typePatrimony.render(typePatrimonyForm));
		  }
		  
		  typePatrimonyForm.get().save();
		  
		  flash("success", "Computer " + typePatrimonyForm.get().description + " has been created");
		  
		  return GO_HOME;
	  }
      
      /**
       * Display the 'edit form' of a existing Computer.
       *
       * @param id Id of the computer to edit
       */
      @Transactional(readOnly=true)
      public static Result edit(Long id) {
          Form<Computer> computerForm = form(Computer.class).fill(
              Computer.findById(id)
          );
          return ok(
              editForm.render(id, computerForm)
          );
      }
      
      /**
       * Display the 'edit form' of a existing Computer.
       *
       * @param id Id of the computer to edit
       */
      @Transactional(readOnly=true)
      public static Result update(Long id) {
          Form<Computer> computerForm = form(Computer.class).fill(
              Computer.findById(id)
          );
          return ok(
              editForm.render(id, computerForm)
          );
      }
      
      public static void delete(Long id) {
      }
      
      public static void list(Long id) {
    	  
      }
      @Transactional(readOnly=true)
      public static Result view(int page, String sortBy, String order, String filter){
    	  
          Form<TypePatrimony> typePatrimonyForm = form(TypePatrimony.class);
          
          return ok(typePatrimony.render(typePatrimonyForm,TypePatrimony.page(page, 20, sortBy, order, filter),sortBy, order, filter));
    	  
      }

}
