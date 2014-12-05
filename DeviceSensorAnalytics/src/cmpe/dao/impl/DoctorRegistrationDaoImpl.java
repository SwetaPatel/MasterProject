package cmpe.dao.impl;

import java.net.UnknownHostException;

import cmpe.entity.DoctorRegistration;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class DoctorRegistrationDaoImpl {
	public String dsignup(Object object) {
		DoctorRegistration pr = (DoctorRegistration) object;
		String email = pr.getDemail();
		 String password = pr.getDpassword();
		 String gender  = pr.getDgender();
	 String fName = pr.getDocFname();
		 String lName = pr.getDocLname();
	//	 int id = pr.getId();
		try { 
			Mongo mongo = new Mongo("localhost", 27017);  
			DB db = mongo.getDB("doctorRegistrationdb"); 
			DBCollection collection = db.getCollection("doctorRegistrationCollection");  
			BasicDBObject document = new BasicDBObject();  
			document.put("email", email);  
			document.put("password", password);  
			document.put("gender", gender);  
			document.put("fName", fName);  
			document.put("lName", lName);    
		//	document.put("id", id);  
			collection.insert(document);  
			System.out.println("Done");  
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
