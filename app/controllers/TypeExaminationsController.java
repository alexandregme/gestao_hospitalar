package controllers;

import java.util.List;

import models.TypeExaminations;
import play.i18n.Messages;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Protocol;

public class TypeExaminationsController extends Controller  {

	private static Protocol protocol = null;
	
    public static Result list() {
        
   	 List<TypeExaminations> professional = TypeExaminations.find.all();
  	 
   	 protocol = new Protocol('s', Messages.get("CONSULTA_REALIZADA"), professional, 1);
  	  	
   	 return ok(Json.toJson(protocol));

    }
}
