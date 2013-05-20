package controllers;

import java.util.List;

import models.Covenants;
import play.i18n.Messages;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Protocol;

public class CovenantsController extends Controller{

	private static Protocol protocol = null;
	
    public static Result list() {
        
   	 List<Covenants> covenants = Covenants.find.all();
  	 
   	 protocol = new Protocol('s', Messages.get("CONSULTA_REALIZADA"), covenants, 1);
  	  	
   	 return ok(Json.toJson(protocol));

    }
}
