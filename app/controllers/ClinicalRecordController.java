package controllers;

import java.util.List;

import models.Beds;
import models.ClinicalRecord;
import models.Intern;
import models.Patient;
import models.Professional;
import models.TypeExaminations;

import org.codehaus.jackson.JsonNode;

import play.i18n.Messages;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Protocol;
import views.html.clinicalRecord;


public class ClinicalRecordController extends Controller{
	
	private static Protocol protocol = null;
	
    public static Result view(Long id){

    	System.out.println(id);
		
		return ok(clinicalRecord.render(id));
   	 
    }
    
	 public static Result save() {
		 
		 JsonNode json = request().body().asJson();
		 
		 ClinicalRecord c = Json.fromJson(json, ClinicalRecord.class);

		 ClinicalRecord clinical = new ClinicalRecord();
		 
		 try{
			 
			 Intern i = Intern.find.byId(c.intern.id);
			 
			 Professional p = Professional.find.byId(c.professional.id);

			 clinical.intern = i;
			 
			 clinical.professional = p;
			 
			 clinical.description = c.description;
			 
			 clinical.save();
			 
			 protocol = new Protocol('s',Messages.get("INSERT"), c, 1);
		 
		 }catch (Exception e){
			 
			 e.printStackTrace();
			 
			 protocol = new Protocol('e' , Messages.get("ERROR"), null, 0);
		 }

		 return ok(Json.toJson(protocol));
	 }
	 
    
    public static Result list() {
    	
		 JsonNode json = request().body().asJson();
		 
		 Intern i = Json.fromJson(json, Intern.class);
    	    	
      	 List<ClinicalRecord> c = ClinicalRecord.find.where("intern = " + i.id).findList();

      	 protocol = new Protocol('s', Messages.get("CONSULTA_REALIZADA"), c, c.size());
     	  	
      	 return ok(Json.toJson(protocol));

       }

}
