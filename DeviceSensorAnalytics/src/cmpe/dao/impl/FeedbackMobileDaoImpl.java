package cmpe.dao.impl;

import java.net.UnknownHostException;


import cmpe.entity.Feedback;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class FeedbackMobileDaoImpl {
	public String feedbackMobile(Object object) { 
		Feedback pr = (Feedback) object;
		 String pemail = pr.getPemail();
//		JSONObject json = new JSONObject();
		 String description = null;
		//String password = pl.getPassword();
		try { 
			Mongo mongo = new Mongo("localhost", 27017);  
			DB db = mongo.getDB("feedbackdb"); 
			System.out.println("aa");
			DBCollection collection = db.getCollection("feedbackCollection");  
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("pemail", pemail);
			DBCursor cursor = collection.find(whereQuery);
			while(cursor.hasNext()) {
				DBObject o = cursor.next();
			description = o.get("description").toString();
//			json.put("status", 200);
//            json.put("description", description);
          
			}
			
			System.out.println("Done details retrieved");
		} catch (UnknownHostException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} catch (MongoException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		}
		return description;
	} 
}
