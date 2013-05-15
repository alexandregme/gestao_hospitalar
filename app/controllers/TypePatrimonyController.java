package controllers;

import static play.data.Form.form;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import models.Computer;
import models.TypePatrimony;
import play.data.Form;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Protocol;
import views.html.createForm;
import views.html.typePatrimony;

public class TypePatrimonyController extends Controller  {
	 
	 public static Result GO_HOME = redirect(routes.Application.view());
	 private static Protocol protocol = null;
	 
	 
    /**
     * Handle default path requests, redirect to doctors list
     */
	 @Transactional
	 public static Result save() {
   	 
//		 TypePatrimony t1 = new TypePatrimony();
//   	  TypePatrimony t2 = new TypePatrimony();
//   	  TypePatrimony t3 = new TypePatrimony();
//   	  TypePatrimony t4 = new TypePatrimony();
//     	  
//
//   	  t1.id=4l;
//   	  t3.id=6l;
//   	  t2.id=5l;
//   	  t4.id=7l;
//   	  
//   	  
//   	  t1.description = "x";
//   	  
//   	  t2.description = "y";
//   	  
//   	  t3.description = "z";
//   	  
//   	  t4.description = "c";
//   	  
//   
//   	  try{
// 			  t1.save();
//  	    	  t2.save();
//  	    	  t3.save();
//  	    	  t4.save();
//
//   	  }catch(Exception e){
//   		  
//   		  e.printStackTrace();
//   		  
//   	  }
		 
		 JsonNode json = request().body().asJson();
		 
		 TypePatrimony tp = Json.fromJson(json, TypePatrimony.class);
		 
		 try{
		 
			 //tp.save();
		 
			 protocol = new Protocol('s',"salvou", tp, 1);
		 
			 Object a = JPA.em().createNativeQuery("SELECT currval('public.typepatrimony_id_seq')").getSingleResult();
			 System.out.println(a);
		 
		 }catch (Exception e){
			 
			 e.printStackTrace();
			 
			 protocol = new Protocol('e',"erro", null, 0);
		 }
	 
 
		 //Form<TypePatrimony> typePatrimonyForm = form(TypePatrimony.class).bindFromRequest();
		  
		  //System.out.println(typePatrimonyForm.);
		  //if(typePatrimonyForm.hasErrors()) {
			  //return ok(Json.toJson("c"));
		  //}
		  
//		  typePatrimonyForm.get().save();
		  
	//	  flash("success", "Computer " + typePatrimonyForm.get().description + " has been created");
		  
		 return ok(Json.toJson(protocol));
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
      
      @Transactional
      public static Result list() {
          
    	  List<TypePatrimony> patrymonies = (List<TypePatrimony>)  JPA.em().createQuery("from TypePatrimony").getResultList();
    	  protocol = new Protocol('s',"teste", patrymonies, 1);
    	  return ok(Json.toJson(protocol));
    	  
      }
      
      
      
      @Transactional(readOnly=true)
      public static Result view(){
    	  
          Form<TypePatrimony> typePatrimonyForm = form(TypePatrimony.class);
          
          return ok(typePatrimony.render());
    	  
      }

}
