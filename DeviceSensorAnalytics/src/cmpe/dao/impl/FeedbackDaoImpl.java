package cmpe.dao.impl;

import java.net.UnknownHostException;

import cmpe.entity.Feedback;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class FeedbackDaoImpl {
	public String feedback(Object object) {
		Feedback pr = (Feedback) object;
		String description = pr.getDescription();
		 String pemail = pr.getPemail();
		
		// int id = pr.getId();
		 System.out.println("aa1");
		try { 
			Mongo mongo = new Mongo("localhost", 27017);  
			DB db = mongo.getDB("feedbackdb"); 
			System.out.println("aa");
			DBCollection collection = db.getCollection("feedbackCollection");  
			BasicDBObject document = new BasicDBObject(); 
			System.out.println("aa");
			document.put("pemail", pemail);  
			document.put("description", description);  
			
			System.out.println("aa");
			collection.insert(document);  
			System.out.println("Done");  
		} catch (UnknownHostException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} catch (MongoException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		}
		return "Hello";
	} 
}
