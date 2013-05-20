package controllers;

import java.util.List;

import models.Authorizations;
import models.Covenants;
import models.Professional;

import org.codehaus.jackson.JsonNode;

import play.i18n.Messages;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Protocol;

public class AuthorizationsController extends Controller{


	private static Protocol protocol = null;

	public static Result byConvenants() {

		try{
			
		JsonNode json = request().body().asJson();

		Covenants c = Json.fromJson(json, Covenants.class);
		
		Covenants coventants = Covenants.find.byId(c.id);

		List<Authorizations> authorizations = Authorizations.find.where("covenant = " + coventants.id).findList();

		protocol = new Protocol('s',Messages.get("CONSULTA_REALIZADA"), authorizations, 1);

	
		} catch (Exception e ){
			e.printStackTrace();
		}
		
		return ok(Json.toJson(protocol));
	}
	
    public static Result getAuthorization() {

    	protocol = new Protocol('s', Messages.get("Autorizado"), true, 1);
  	  	
   	 	return ok(Json.toJson(protocol));

    }
}