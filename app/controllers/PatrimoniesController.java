package controllers;

import static play.data.Form.form;

import java.util.List;

import models.Company;
import models.Computer;
import models.Patrimonies;

import org.codehaus.jackson.JsonNode;

import play.data.Form;
import play.db.ebean.Model.Finder;
import play.i18n.Messages;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import scala.collection.parallel.ParIterableLike.Find;
import utils.Protocol;
import views.html.patrimonies;

public class PatrimoniesController extends Controller  {
	 
	 private static Protocol protocol = null;
	 
	 public static Result edit() {
		 JsonNode json = request().body().asJson();
		 Patrimonies tp = Json.fromJson(json, Patrimonies.class);
	
		 try{
			 Patrimonies typepatrimony = Patrimonies.find.ref(tp.id);
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
		 Patrimonies tp = Json.fromJson(json, Patrimonies.class);
	
		 try{
			 Patrimonies.find.ref(tp.id).delete();
			 
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
		 
		 Patrimonies tp = Json.fromJson(json, Patrimonies.class);
		 
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

    	 return ok(patrimonies.render());
    	 
     }
     
      
     
     public static Result list() {
         
    	 List<Patrimonies> patrymonies = Patrimonies.find.all();
   	 
    	 protocol = new Protocol('s',Messages.get("CONSULTA_REALIZADA"), patrymonies, 1);
    	 
    	 return ok(Json.toJson(protocol));

     }

}
