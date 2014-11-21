package cmpe.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import cmpe.dao.impl.DoctorNameDaoImpl;

@Path("/dList")
public class DoctorNameService {
	@GET
	@Path("/listofDoctors")
	
	  public Response get_dList() {
		
		DoctorNameDaoImpl Sidao = new DoctorNameDaoImpl();
    	List<String> Output =  Sidao.dList();
 
    	return Response.status(200).entity(Output.toString()).build();
	}
}
