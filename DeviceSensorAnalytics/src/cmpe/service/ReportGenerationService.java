package cmpe.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import cmpe.dao.impl.ReportGenerationDaoImpl;
import cmpe.entity.ReportGeneration;


@Path("/report")
public class ReportGenerationService {
	@GET
	@Path("/{pemail}")
	
	  public Response get_psignin(@PathParam("pemail") String pemail) {
//		
		ReportGeneration si = new ReportGeneration();
    	si.setPemail(pemail);
    	ReportGenerationDaoImpl Sidao = new ReportGenerationDaoImpl();
    	String Output =  Sidao.reportGen(si);
	 	//String Output = "hello";
    	
    	return Response.status(200).entity(Output).build();
		
	}
}

