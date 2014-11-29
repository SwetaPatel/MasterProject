package cmpe.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.json.simple.JSONObject;


import utils.Session;

@Path("/language")
public class LanguageService {
	@POST
    @Path("/{lang}")
	public String language(@PathParam("lang") String slang) {
	 
		Session se = Session.getInstance();
        se.setLanguage(slang);
        System.out.println("SWETA: spanish called");
        String check = se.getLanguage();
	    System.out.println("SWETA SET Language: "+check);	
	    	JSONObject json = new JSONObject();
            json.put("status", 200);
           
            return json.toString();
	}

}
