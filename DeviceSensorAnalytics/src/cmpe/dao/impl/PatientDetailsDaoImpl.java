package cmpe.dao.impl;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.BasicBSONObject;
import org.json.simple.JSONObject;

import cmpe.entity.PatientRegistration;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class PatientDetailsDaoImpl {
	public String pDetails(Object object) { 
		PatientRegistration pl = (PatientRegistration) object;
		String email = pl.getEmail();
		JSONObject json = new JSONObject();
		//String password = pl.getPassword();
		try { 
			@SuppressWarnings("deprecation")
			Mongo mongo = new Mongo("localhost", 27017);  
			DB db = mongo.getDB("patientRdb"); 
			DBCollection collection = db.getCollection("patientRCollection");  
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("email", email);
			DBCursor cursor = collection.find(whereQuery);
			
			while(cursor.hasNext()) {
				DBObject o = cursor.next();
			String pemail = o.get("pemail").toString();
			String gender = o.get("gender").toString();
			String fName = o.get("fName").toString();
			String lName = o.get("lName").toString();
			String age = o.get("age").toString();
			
			json.put("status", 200);
            json.put("pemail", pemail);
            json.put("gender", gender);
            json.put("fName", fName);
            json.put("lName", lName);
			json.put("age",  age);
			}
			
			System.out.println("Done details retrieved");
		} catch (UnknownHostException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} catch (MongoException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		}
		return json.toString();
	} 
}
