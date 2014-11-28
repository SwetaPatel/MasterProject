package cmpe.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import cmpe.dao.impl.PatientLoginDaoImpl;
import cmpe.entity.PatientRegistration;
@Path("/psignin")
public class PatientLoginService {
	@GET
	@Path("/{email}/{password}")
	
	  public String get_psignin(@PathParam("email") String email, @PathParam("password") String password) {
//		
		PatientRegistration si = new PatientRegistration();
    	si.setEmail(email);
    	si.setPassword(password);
    	PatientLoginDaoImpl Sidao = new PatientLoginDaoImpl();
    	String Output =  Sidao.psignin(si);
	 	//String Output = "hello";
    	JSONObject json = new JSONObject();
    	if(Output=="yes"){
    		json.put("status", 200);
    	}
    	else if(Output=="no"){
    		json.put("status", 401);
    	}
        return json.toString();
	}
}