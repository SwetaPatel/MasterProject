package cmpe.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import cmpe.dao.impl.PatientListDaoImpl;
import cmpe.entity.PatientList;
@Path("/plist")
public class PatientListService {
	@GET
    @Path("/{demail}")
	public Response psignup(@PathParam("demail") String demail) {
		PatientList su = new PatientList();
	    	su.setDemail(demail);
	    	
	    	PatientListDaoImpl Sudao = new PatientListDaoImpl();
	    	
	    	List<String> Output = Sudao.pList(su);
	    	return Response.status(200).entity(Output.toString()).build();
	    		
	}
}
