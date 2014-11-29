package cmpe.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import cmpe.dao.impl.ReportGenerationDaoImpl;
import cmpe.entity.CollectHealthData;


@Path("/report")
public class ReportGenerationService {
	@GET
	@Path("/{pemail}")
	
	  public String getReportData(@PathParam("pemail") String pemail) {
//		
		CollectHealthData si = new CollectHealthData();
    	si.setPemail(pemail);
    	ReportGenerationDaoImpl Sidao = new ReportGenerationDaoImpl();
    	String Output =  Sidao.reportGen(si);
	 	//String Output = "hello";
    	
    	return Output;
		
	}
}

