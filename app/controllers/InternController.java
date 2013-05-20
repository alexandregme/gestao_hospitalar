package controllers;

import java.util.List;

import models.Beds;
import models.Intern;
import models.Professional;

import org.codehaus.jackson.JsonNode;

import play.i18n.Messages;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Protocol;

public class InternController extends Controller  {
	
	private static Protocol protocol = null;
	
	public static Result intern() {

		JsonNode json = request().body().asJson();

		Intern i = Json.fromJson(json, Intern.class);

		try{
			Beds b = Beds.find.byId(i.bed.id);
			
			b.available = false;
			
			b.save();
			
			i.save();

			protocol = new Protocol('s',Messages.get("INSERT"), i, 1);

		}catch (Exception e){

			e.printStackTrace();

			protocol = new Protocol('e' , Messages.get("ERROR"), null, 0);
		}

		return ok(Json.toJson(protocol));
	}

    
    public static Result list() {
        
   	 List<Intern> intern = Intern.find.all();
  	 
   	 protocol = new Protocol('s', Messages.get("CONSULTA_REALIZADA"), intern, 1);
  	  	
   	 return ok(Json.toJson(protocol));

    }
}
