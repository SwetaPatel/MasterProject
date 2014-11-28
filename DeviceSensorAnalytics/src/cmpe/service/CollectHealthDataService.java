package cmpe.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import cmpe.dao.impl.CollectHealthDataDaoImpl;
import cmpe.entity.CollectHealthData;

@Path("/collectData")
public class CollectHealthDataService {
	@POST
	@Path("/{pemail}/{highBp}/{lowBp}/{timestamp}")
	public Response psignup(@PathParam("pemail") String pemail, 
			@PathParam("highBp") String highBp, @PathParam("lowBp") String lowBp, 
			@PathParam("timestamp") String timestamp) throws ParseException {
		System.out.println("aa2");
	
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = formatter.parse(timestamp);
		CollectHealthData su = new CollectHealthData();
		su.setPemail(pemail);
		su.setHighBp(highBp);
		su.setLowBp(lowBp);
		su.setDateVal(date);
		System.out.println("aa3");
		CollectHealthDataDaoImpl Sudao = new CollectHealthDataDaoImpl();
		System.out.println("aa4");
		String Output = Sudao.collectData(su);
		return Response.status(200).entity(Output).build();

	}
}

