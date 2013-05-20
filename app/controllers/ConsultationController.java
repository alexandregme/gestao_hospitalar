package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.consultation;

public class ConsultationController extends Controller{
	
    public static Result view(){

   	 return ok(consultation.render());
   	 
    }

}
