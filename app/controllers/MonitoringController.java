package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.monitoring;

public class MonitoringController  extends Controller{
	
    public static Result view(){

   	 return ok(monitoring.render());
   	 
    }
}
