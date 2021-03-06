package cmpe.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import cmpe.dao.impl.PatientRegistrationDaoImpl;
import cmpe.entity.PatientRegistration;
@Path("/psignup")
public class PatientRegistrationService {
	@POST
    @Path("/{email}/{password}/{fName}/{lName}/{gender}/{age}/{demail}")
	public String psignup(@PathParam("email") String email, @PathParam("password") String password, @PathParam("fName") String fName, @PathParam("lName") String lName, 
			@PathParam("gender") String gender, @PathParam("age") String age, @PathParam("demail") String demail) {
		
		System.out.println("aa2");
		int pAge = Integer.parseInt(age);
	//	int pId = Integer.parseInt(id);
		PatientRegistration su = new PatientRegistration();
	    	su.setEmail(email);
	    	su.setPassword(password);
	    	su.setfName(fName);;
	    	su.setlName(lName);
	    	su.setGender(gender);
	    	su.setAge(pAge);
	    	su.setDemail(demail);
	  
	    	System.out.println("aa3");
	    	PatientRegistrationDaoImpl Sudao = new PatientRegistrationDaoImpl();
	    	System.out.println("aa4");
	    	String Output = Sudao.psignup(su);
	    	JSONObject json = new JSONObject();
            json.put("status", 200);
            return json.toString();	
	}
}
