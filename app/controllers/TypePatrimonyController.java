package controllers;

import static play.data.Form.form;

import java.util.List;

import models.Company;
import models.Computer;
import models.TypePatrimony;

import org.codehaus.jackson.JsonNode;

import play.data.Form;
import play.db.ebean.Model.Finder;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import scala.collection.parallel.ParIterableLike.Find;
import utils.Protocol;
import views.html.typePatrimony;

public class TypePatrimonyController extends Controller  {
	 
	 private static Protocol protocol = null;
	 
	 public static Result edit() {
		 JsonNode json = request().body().asJson();
		 TypePatrimony tp = Json.fromJson(json, TypePatrimony.class);
	
		 try{
			 TypePatrimony typepatrimony = TypePatrimony.find.ref(tp.id);
			 typepatrimony.description = tp.description;
			 typepatrimony.save();
			 protocol = new Protocol('s',"Editou", tp, 1);
		 
		 }catch (Exception e){
			 
			 e.printStackTrace();
			 
			 protocol = new Protocol('e',"erro", null, 0);
		 }
		 return ok(Json.toJson(protocol));
	    }
	    
	 public static Result delete() {
		 JsonNode json = request().body().asJson();
		 TypePatrimony tp = Json.fromJson(json, TypePatrimony.class);
	
		 try{
			 TypePatrimony.find.ref(tp.id).delete();
			 
			 protocol = new Protocol('s',"deletou", tp, 1);
		 
		 }catch (Exception e){
			 
			 e.printStackTrace();
			 
			 protocol = new Protocol('e',"erro", null, 0);
		 }
		 return ok(Json.toJson(protocol));
	    }
	    
    /**
     * Handle default path requests, redirect to doctors list
     */
	 public static Result save() {
		 JsonNode json = request().body().asJson();
		 
		 TypePatrimony tp = Json.fromJson(json, TypePatrimony.class);
		 
		 try{
			 tp.save();
			 
			 protocol = new Protocol('s',"salvou", tp, 1);
		 
		 }catch (Exception e){
			 
			 e.printStackTrace();
			 
			 protocol = new Protocol('e',"erro", null, 0);
		 }

		 return ok(Json.toJson(protocol));
	 }
     public static Result view(){

    	 return ok(typePatrimony.render());
    	 
     }
     
      
     
     public static Result list() {
         
    	 List<TypePatrimony> patrymonies = TypePatrimony.find.all();
   	 
    	 protocol = new Protocol('s',"teste", patrymonies, 1);
   	  	
    	 return ok(Json.toJson(protocol));

     }

}
