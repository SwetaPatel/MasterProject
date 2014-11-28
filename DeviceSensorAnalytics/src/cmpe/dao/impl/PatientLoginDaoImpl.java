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

public class PatientLoginDaoImpl {
	public String psignin(Object object) { 
		PatientRegistration pl = (PatientRegistration) object;
		String email = pl.getEmail();
		String password = pl.getPassword();
		String out = null;
		try { 
			Mongo mongo = new Mongo("localhost", 27017);  
			DB db = mongo.getDB("patientRdb"); 
			DBCollection collection = db.getCollection("patientRCollection");  
			BasicDBObject andQuery = new BasicDBObject();
			List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
			obj.add(new BasicDBObject("email", email));
			obj.add(new BasicDBObject("password", password));
			andQuery.put("$and", obj);
		//	System.out.println(andQuery.toString());
			DBCursor cursor = collection.find(andQuery);
			if(cursor.hasNext()) {
			    System.out.println(cursor.next());
//				String a = (cursor.next().get("pemail")).toString();
//				System.out.println(a);
			    out = "yes";
			}
			else{
				System.out.println("no value exists");
				out =  "no";
			}
			System.out.println("Done");
		} catch (UnknownHostException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} catch (MongoException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		}
		return out;
	} 

}
