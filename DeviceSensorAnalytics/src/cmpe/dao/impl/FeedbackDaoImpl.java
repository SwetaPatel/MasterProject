package cmpe.dao.impl;

import java.net.UnknownHostException;

import cmpe.entity.Feedback;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class FeedbackDaoImpl {
	public String feedback(Object object) {
		Feedback pr = (Feedback) object;
		String description = pr.getDescription();
		 String pemail = pr.getPemail();
		 System.out.println(pemail);
		 String myout = null;
		// int id = pr.getId();
		 System.out.println("aa1");
		try { 
			Mongo mongo = new Mongo("localhost", 27017);  
			DB db = mongo.getDB("feedbackdb"); 
			System.out.println("aa");
			DBCollection collection = db.getCollection("feedbackCollection");  
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("pemail", pemail);
			DBCursor cursor = collection.find(whereQuery);
			if(cursor.hasNext()){
			 System.out.println("call update");
			myout = updateFeedback(pemail, description);
			}
			else
			{
			BasicDBObject document = new BasicDBObject(); 
			System.out.println("aa5");
			document.put("pemail", pemail);  
			document.put("description", description);  
			
			System.out.println("aa7");
			collection.insert(document);  
			System.out.println("Done"); 
			myout = "done";
			}
		} catch (UnknownHostException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} catch (MongoException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		}
		
		return myout;
	}
	public String updateFeedback(String pemail, String  description) {
		try { 
			Mongo mongo = new Mongo("localhost", 27017);  
			DB db = mongo.getDB("feedbackdb"); 
			System.out.println("aa");
			DBCollection collection = db.getCollection("feedbackCollection"); 
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.append("$set", new BasicDBObject().append("description", description));
			 
			BasicDBObject searchQuery = new BasicDBObject().append("pemail", pemail);
		 
			collection.update(searchQuery, newDocument); 
			
		} catch (UnknownHostException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} catch (MongoException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		}
		return "hello";
	}
}
