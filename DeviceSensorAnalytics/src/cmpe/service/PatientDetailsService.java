package cmpe.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import cmpe.dao.impl.PatientDetailsDaoImpl;
import cmpe.entity.PatientRegistration;
@Path("/pdetails")
public class PatientDetailsService {
	@GET
	@Path("/{email}")
	
	  public String get_pDetials(@PathParam("email") String email) {
//		
		PatientRegistration si = new PatientRegistration();
    	si.setEmail(email);
    	PatientDetailsDaoImpl Sidao = new PatientDetailsDaoImpl();
    	String Output =  Sidao.pDetails(si);
	 	//String Output = "hello";
    	
    	return Output;
		
	}
}

