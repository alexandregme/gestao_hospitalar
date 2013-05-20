package controllers;

import java.util.List;

import models.Patient;

import org.codehaus.jackson.JsonNode;

import play.i18n.Messages;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Protocol;
import views.html.patient;

public class PatientController extends Controller  {

	 private static Protocol protocol = null;
	 
	 public static Result save() {
		 
		 JsonNode json = request().body().asJson();
		 
		 Patient p = Json.fromJson(json, Patient.class);
		 
		 try{
			 
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
	 Patient p = Json.fromJson(json, Patient.class);

	 try{
		 Patient patient = Patient.find.ref(p.id);
		 
		 patient.name = p.name;
		 
		 patient.endereco = p.endereco;
		 
		 patient.cpf = p.cpf;
		 
		 patient.save();
		 
		 protocol = new Protocol('s',"Editou", p, 1);
	 
	 }catch (Exception e){
		 
		 e.printStackTrace();
		 
		 protocol = new Protocol('e',"erro", null, 0);
	 }
	 return ok(Json.toJson(protocol));
    }
    
 public static Result delete() {
	 JsonNode json = request().body().asJson();
	 Patient p = Json.fromJson(json, Patient.class);

	 try{
		 Patient.find.ref(p.id).delete();
		 
		 protocol = new Protocol('s',"deletou", p, 1);
	 
	 }catch (Exception e){
		 
		 e.printStackTrace();
		 
		 protocol = new Protocol('e',"erro", null, 0);
	 }
	 return ok(Json.toJson(protocol));
    }
	public static Result view(){

		return ok(patient.render());

	} 

	public static Result list() {

		List<Patient> patients = Patient.find.all();

		protocol = new Protocol('s',Messages.get("CONSULTA_REALIZADA"), patients, 1);

		return ok(Json.toJson(protocol));

	}


}
