package controllers;

import java.util.List;

import models.Beds;
import models.ClinicalRecord;
import models.Intern;

import org.codehaus.jackson.JsonNode;

import play.i18n.Messages;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Protocol;
import views.html.principal;

public class InternController extends Controller  {

	private static Protocol protocol = null;

	public static Result intern() {

		JsonNode json = request().body().asJson();

		Intern i = Json.fromJson(json, Intern.class);
		
		try{
			Beds b = Beds.find.byId(i.bed.id);

			b.available = false;

			b.save();

			i.released = false;
			
			i.save();

			protocol = new Protocol('s',Messages.get("INSERT"), i, 1);

		}catch (Exception e){

			e.printStackTrace();

			protocol = new Protocol('e' , Messages.get("ERROR"), null, 0);
		}

		 return ok(principal.render());
	}

	public static Result release() {

		JsonNode json = request().body().asJson();

		Intern i = Json.fromJson(json, Intern.class);
		
		Intern intern = Intern.find.byId(i.id);

		try{

			Beds b = Beds.find.byId(intern.bed.id);

			b.available = true;

			b.save();

			intern.released = true;
			
			intern.save();

			protocol = new Protocol('s',"Leito Liberado", i, 1);

		}catch (Exception e){

			e.printStackTrace();

			protocol = new Protocol('e',"erro", null, 0);
		}
		return ok(Json.toJson(protocol));
	}

	public static Result list() {
		 
		List<Intern> intern = Intern.find.where("released = false").findList();

		protocol = new Protocol('s', Messages.get("CONSULTA_REALIZADA"), intern, 1);

		return ok(Json.toJson(protocol));

	}
	
	public static Result getinfo() {

		JsonNode json = request().body().asJson();
		
		Intern i = Json.fromJson(json, Intern.class);
		
		Intern intern = Intern.find.byId(i.id);

		protocol = new Protocol('s', Messages.get("CONSULTA_REALIZADA"), intern, 1);

		return ok(Json.toJson(protocol));

	}
}
