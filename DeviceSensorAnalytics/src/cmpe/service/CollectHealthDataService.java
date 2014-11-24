package cmpe.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import cmpe.dao.impl.CollectHealthDataDaoImpl;
import cmpe.entity.CollectHealthData;

@Path("/collectData")
public class CollectHealthDataService {
	@POST

	@Path("/{pemail}/{highBp}/{lowBp}/{bpsReading}")
	public Response psignup(@PathParam("pemail") String pemail, @PathParam("highBp") String highBp, @PathParam("lowBp") String lowBp, @PathParam("bpsReading") String bpsReading) {
		System.out.println("aa2");

		CollectHealthData su = new CollectHealthData();
		su.setPemail(pemail);
		su.setHighBp(highBp);
		su.setLowBp(lowBp);
		su.setBpsReading(bpsReading);
		System.out.println("aa3");
		CollectHealthDataDaoImpl Sudao = new CollectHealthDataDaoImpl();
		System.out.println("aa4");
		String Output = Sudao.collectData(su);
		return Response.status(200).entity(Output).build();

	}
}

