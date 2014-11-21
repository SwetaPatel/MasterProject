package cmpe.dao.impl;

import java.net.UnknownHostException;

import cmpe.entity.PatientRegistration;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class PatientRegistrationDaoImpl {
	public String psignup(Object object) {
		PatientRegistration pr = (PatientRegistration) object;
		String email = pr.getEmail();
		 String password = pr.getPassword();
		 String gender  = pr.getGender();
	 String fName = pr.getfName();
		 String lName = pr.getlName();
		 int age = pr.getAge();
		 String demail = pr.getEmail();
		// int id = pr.getId();
		try { 
			@SuppressWarnings("deprecation")
			Mongo mongo = new Mongo("localhost", 27017);  
			DB db = mongo.getDB("patientRegistrationdb"); 
			DBCollection collection = db.getCollection("pateintRegistrationCollection");  
			BasicDBObject document = new BasicDBObject();  
			document.put("email", email);  
			document.put("password", password);  
			document.put("gender", gender);  
			document.put("fName", fName);  
			document.put("lName", lName);  
			document.put("age", age);  
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
		try{
		@SuppressWarnings("deprecation")
		Mongo mongo = new Mongo("localhost", 27017);  
		DB db = mongo.getDB("dPlist"); 
		DBCollection collection = db.getCollection("dPListCollection");
		BasicDBObject document1 = new BasicDBObject(); 
		document1.put("demail" , demail);
		document1.put("pemail" , email);
		collection.insert(document1);  
		System.out.println("Done");  
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
