package cmpe.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import cmpe.dao.impl.DoctorRegistrationDaoImpl;
import cmpe.entity.DoctorRegistration;

@Path("/dsignup")
public class DoctorRegistrationService {
	@POST
    @Path("/{email}/{password}/{fName}/{lName}/{gender}")
	public Response dsignup(@PathParam("demail") String demail, @PathParam("dpassword") String dpassword, @PathParam("docFname") String docFname, @PathParam("docLname") String docLname, 
			@PathParam("dgender") String dgender) {
	    	
		
//		long time = System.currentTimeMillis();
//		Timestamp timestamp = new Timestamp(time);
	//	int dId = Integer.parseInt(id);
		
		DoctorRegistration su = new DoctorRegistration();
	    	su.setDemail(demail);;
	    	su.setDpassword(dpassword);
	    	su.setDocFname(docFname);
	    	su.setDocLname(docLname);
	    	su.setDgender(dgender);
	    //	su.setId(dId);
	    	//su.setTimestamp(timestamp);
	    	
	    	DoctorRegistrationDaoImpl Sudao = new DoctorRegistrationDaoImpl();
	    	
	    	String Output = Sudao.dsignup(su);
	    	return Response.status(200).entity(Output).build();
	    		
	}
}
