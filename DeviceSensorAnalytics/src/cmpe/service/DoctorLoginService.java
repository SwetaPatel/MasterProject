package cmpe.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import cmpe.dao.impl.DoctorLoginDaoImpl;
import cmpe.entity.DoctorLogin;
@Path("/dsignin")
public class DoctorLoginService {
	@GET
	@Path("/{email}/{password}")
	
	  public String get_dsignin(@PathParam("email") String email, @PathParam("password") String password) {
		
		DoctorLogin si = new DoctorLogin();
    	si.setEmail(email);
    	si.setPassword(password);
    	DoctorLoginDaoImpl Sidao = new DoctorLoginDaoImpl();
    	String Output =  Sidao.dsignin(si);
    	JSONObject json = new JSONObject();
        json.put("status", 200);
       
        return json.toString();
	}
}
