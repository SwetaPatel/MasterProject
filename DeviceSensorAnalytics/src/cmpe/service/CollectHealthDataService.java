package cmpe.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import cmpe.dao.impl.CollectHealthDataDaoImpl;
import cmpe.entity.CollectHealthData;

@Path("/collectData")
public class CollectHealthDataService {
	@POST
	@Path("/{pemail}/{highBp}/{lowBp}")
	public String psignup(@PathParam("pemail") String pemail, 
			@PathParam("highBp") String highBp, @PathParam("lowBp") String lowBp) throws ParseException {
//		
		String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = formatter.parse(dateFormat);
		System.out.println("date");
		CollectHealthData su = new CollectHealthData();
		su.setPemail(pemail);
		su.setHighBp(highBp);
		su.setLowBp(lowBp);
		su.setDateVal(date);
		
		CollectHealthDataDaoImpl Sudao = new CollectHealthDataDaoImpl();
		
		String Output = Sudao.collectData(su);
//		return Response.status(200).entity(Output).build();
		JSONObject json = new JSONObject();
        json.put("status", 200);
        return json.toString();	

	}
}

