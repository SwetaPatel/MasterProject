package cmpe.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import cmpe.dao.impl.FeedbackDaoImpl;
import cmpe.entity.Feedback;


@Path("/feedback")
public class FeedbackService {
	@POST
    @Path("/{email}/{description}")
	public Response psignup(@PathParam("pemail") String pemail, @PathParam("description") String description) {
		
		System.out.println("aa2");
		
		Feedback su = new Feedback();
	    	su.setPemail(pemail);
	    	su.setDescription(description);
	    	System.out.println("aa3");
	    	FeedbackDaoImpl Sudao = new FeedbackDaoImpl();
	    	System.out.println("aa4");
	    	String Output = Sudao.feedback(su);
	    	return Response.status(200).entity(Output).build();
	    		
	}
}
