package cmpe.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import cmpe.dao.impl.FeedbackDaoImpl;
import cmpe.entity.Feedback;


@Path("/feedback")
public class FeedbackService {
	@POST
    @Path("/{pemail}/{description}")
	public String giveFeedback(@PathParam("pemail") String pemail, @PathParam("description") String description) {
		
		System.out.println("aa2");
		
		Feedback su = new Feedback();
	    	su.setPemail(pemail);
	    	su.setDescription(description);
	    	System.out.println("aa3");
	    	FeedbackDaoImpl Sudao = new FeedbackDaoImpl();
	    	System.out.println("aa4");
	    	String Output = Sudao.feedback(su);
	    	JSONObject json = new JSONObject();
            json.put("status", 200);
           
            return json.toString();	
	}
}
