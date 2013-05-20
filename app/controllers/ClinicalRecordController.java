package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.patrimonies;

public class ClinicalRecordController extends Controller{
	
    public static Result view(){

   	 return ok(patrimonies.render());
   	 
    }

}
