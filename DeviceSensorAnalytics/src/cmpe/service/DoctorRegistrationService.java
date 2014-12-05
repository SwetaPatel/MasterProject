package cmpe.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import cmpe.dao.impl.DoctorRegistrationDaoImpl;
import cmpe.entity.DoctorRegistration;


@Path("/dsignup")
public class DoctorRegistrationService {
	@POST
    @Path("/{email}/{password}/{fName}/{lName}/{gender}")
	public String dsignup(@PathParam("email") String demail, @PathParam("password") String dpassword, @PathParam("fName") String docFname, @PathParam("lName") String docLname, 
			@PathParam("gender") String dgender) {
	 
		DoctorRegistration su = new DoctorRegistration();
	    	su.setDemail(demail);;
	    	su.setDpassword(dpassword);
	    	su.setDocFname(docFname);
	    	su.setDocLname(docLname);
	    	su.setDgender(dgender);
//	    	System.out.println(demail);
//	    	System.out.println(dpassword);
//	    	System.out.println(docFname);
//	    	System.out.println(dgender);
	    	DoctorRegistrationDaoImpl Sudao = new DoctorRegistrationDaoImpl();
	    	
	    	String Output = Sudao.dsignup(su);
	    	
	    	JSONObject json = new JSONObject();
            json.put("status", 200);
           
            return json.toString();
	}
}
