package cmpe.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;




import cmpe.dao.impl.FeedbackMobileDaoImpl;
import cmpe.entity.Feedback;
@Path("getfeed")
public class FeedbackMobileService {
	@GET
    @Path("/{pemail}")
	public String getFeedback(@PathParam("pemail") String pemail) {
		Feedback su = new Feedback();
	    	su.setPemail(pemail);
	    	
	    	FeedbackMobileDaoImpl Sudao = new FeedbackMobileDaoImpl();
	    	
	    	String Output = Sudao.feedbackMobile(su);
	    	 
	    		if(Output == null){
	    			return "No feedback avaialble yet";
	    		}
	    		else
            
            return Output;
		
	}
}
