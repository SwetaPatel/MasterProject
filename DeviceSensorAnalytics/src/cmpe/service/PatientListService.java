package cmpe.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


import org.json.simple.JSONObject;



import cmpe.dao.impl.PatientListDaoImpl;
import cmpe.entity.PatientList;
@Path("/plist")
public class PatientListService {
	@GET
    @Path("/{demail}")
	public String psignup(@PathParam("demail") String demail) {
		PatientList su = new PatientList();
	    	su.setDemail(demail);
	    	
	    	PatientListDaoImpl Sudao = new PatientListDaoImpl();
	    	
	    	List<String> Output = Sudao.pList(su);
	    	 

            JSONObject json = new JSONObject();
            json.put("status", 200);
            json.put("patientList", Output);
            return json.toString();

	    		
	}
}
