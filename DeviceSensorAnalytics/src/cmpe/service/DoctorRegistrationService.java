package cmpe.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import cmpe.dao.impl.DoctorRegistrationDaoImpl;
import cmpe.entity.DoctorRegistration;

import com.google.gson.Gson;

@Path("/dsignup")
public class DoctorRegistrationService {
	@POST
    @Path("/{email}/{password}/{fName}/{lName}/{gender}")
	public String dsignup(@PathParam("demail") String demail, @PathParam("dpassword") String dpassword, @PathParam("docFname") String docFname, @PathParam("docLname") String docLname, 
			@PathParam("dgender") String dgender) {
	 
		DoctorRegistration su = new DoctorRegistration();
	    	su.setDemail(demail);;
	    	su.setDpassword(dpassword);
	    	su.setDocFname(docFname);
	    	su.setDocLname(docLname);
	    	su.setDgender(dgender);
	  
	    	DoctorRegistrationDaoImpl Sudao = new DoctorRegistrationDaoImpl();
	    	
	    	String Output = Sudao.dsignup(su);
	    	
	    	JSONObject json = new JSONObject();
            json.put("status", 200);
           
            return json.toString();
	}
}
