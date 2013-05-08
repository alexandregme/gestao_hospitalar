package controllers;

import static play.data.Form.form;
import models.Computer;
import models.TypePatrimony;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.typePatrimony;

public class TypePatrimonyController extends Controller  {
	
	 public static Result GO_HOME = redirect(routes.Application.view());
	 
    /**
     * Handle default path requests, redirect to doctors list
     */
	 public static Result save() {
		  
		  Form<TypePatrimony> typePatrimonyForm = form(TypePatrimony.class).bindFromRequest();
		  
		  if(typePatrimonyForm.hasErrors()) {
			  return ok(Json.toJson("c"));
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
          Form<Computer> editForm = form(Computer.class).fill(
              Computer.findById(id)
          );
          return ok(Json.toJson("c"));
      }
      
      /**
       * Display the 'edit form' of a existing Computer.
       *
       * @param id Id of the computer to edit
       */
      @Transactional(readOnly=true)
      public static Result update(Long id) {
          Form<Computer> editForm = form(Computer.class).fill(
              Computer.findById(id)
          );
          return ok(Json.toJson("c"));
      }
      
      public static Result delete(Long id) {
    	  return ok(Json.toJson("c"));
      }
      
      public static Result list(Long id) {
    	  return ok(Json.toJson("c"));
    	  
      }
      @Transactional(readOnly=true)
      public static Result view(){
    	  
          Form<TypePatrimony> typePatrimonyForm = form(TypePatrimony.class);
          
          return ok(typePatrimony.render());
    	  
      }

}
