package cmpe.dao.impl;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import cmpe.entity.PatientRegistration;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class PatientDetailsDaoImpl {
	public List<String> pDetails(Object object) { 
		PatientRegistration pl = (PatientRegistration) object;
		String email = pl.getEmail();
		List<String> li = new ArrayList<String>();
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
			    System.out.println(cursor.next());
			    li.add(cursor.next().toString());
			}
			System.out.println(li);
			System.out.println("Done details retrieved");
		} catch (UnknownHostException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} catch (MongoException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		}
		return null;
	} 
}
