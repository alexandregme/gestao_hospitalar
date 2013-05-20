package controllers;
import java.util.List;

import models.Professional;
import models.TypeExaminations;

import org.codehaus.jackson.JsonNode;

import play.i18n.Messages;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Protocol;
import views.html.professional;

public class ProfessionalController extends Controller  {
	 
	 private static Protocol protocol = null;
	 
		 public static Result save() {
			 
			 JsonNode json = request().body().asJson();
			 
			 Professional p = Json.fromJson(json, Professional.class);
			 
			 try{
				 
				 TypeExaminations te = TypeExaminations.find.ref(p.typeexamination.id);
				 
				 p.typeexamination = te;
				 
				 p.save();
				 
				 protocol = new Protocol('s',Messages.get("INSERT"), p, 1);
			 
			 }catch (Exception e){
				 
				 e.printStackTrace();
				 
				 protocol = new Protocol('e' , Messages.get("ERROR"), null, 0);
			 }

			 return ok(Json.toJson(protocol));
		 }
		 
	 public static Result edit() {
		 JsonNode json = request().body().asJson();
		 Professional p = Json.fromJson(json, Professional.class);
	
		 try{
			 Professional professional = Professional.find.ref(p.id);
			 
			 TypeExaminations te = TypeExaminations.find.ref(p.typeexamination.id);
			 
			 professional.name = p.name;
			 
			 professional.document = p.document;
			 
			 professional.typeexamination = te;
			 
			 professional.save();
			 
			 protocol = new Protocol('s',"Editou", p, 1);
		 
		 }catch (Exception e){
			 
			 e.printStackTrace();
			 
			 protocol = new Protocol('e',"erro", null, 0);
		 }
		 return ok(Json.toJson(protocol));
	    }
	    
	 public static Result delete() {
		 JsonNode json = request().body().asJson();
		 Professional p = Json.fromJson(json, Professional.class);
	
		 try{
			 Professional.find.ref(p.id).delete();
			 
			 protocol = new Protocol('s',"deletou", p, 1);
		 
		 }catch (Exception e){
			 
			 e.printStackTrace();
			 
			 protocol = new Protocol('e',"erro", null, 0);
		 }
		 return ok(Json.toJson(protocol));
	    }

	 public static Result view(){

    	 return ok(professional.render());
    	 
     }
     
     public static Result list() {
         
    	 List<Professional> professional = Professional.find.all();
   	 
    	 protocol = new Protocol('s', Messages.get("CONSULTA_REALIZADA"), professional, 1);
   	  	
    	 return ok(Json.toJson(protocol));

     }
}
