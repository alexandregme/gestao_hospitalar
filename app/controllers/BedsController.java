package controllers;

import java.util.List;

import models.Beds;
import play.i18n.Messages;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Protocol;

public class BedsController  extends Controller{

	private static Protocol protocol = null;
	
    public static Result list() {
        
   	 List<Beds> beds = Beds.find.where("available = true").findList();
  	 
   	 protocol = new Protocol('s', Messages.get("CONSULTA_REALIZADA"), beds, 1);
  	  	
   	 return ok(Json.toJson(protocol));

    }
}
