package controllers;

import java.util.List;

import models.ClinicRecord;
import models.Intern;
import play.i18n.Messages;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Protocol;
import views.html.monitoring;

public class MonitoringController  extends Controller{
	
	private static Protocol protocol = null;
  	 
    public static Result view(){

   	 return ok(monitoring.render());
   	 
    }
    
	public static Result addInformation(Long id) {

		Intern i = Intern.find.byId(id);
		

		List<ClinicRecord> cr = ClinicRecord.find.all();

		protocol = new Protocol('s', Messages.get("CONSULTA_REALIZADA"), cr, 1);

		return ok(monitoring.render());

	}
    
}
