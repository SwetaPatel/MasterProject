package cmpe.dao.impl;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import cmpe.entity.DoctorLogin;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class DoctorLoginDaoImpl {
	public String dsignin(Object object) { 
		DoctorLogin pl = (DoctorLogin) object;
		String email = pl.getEmail();
		String password = pl.getPassword();
		try { 
			@SuppressWarnings("deprecation")
			Mongo mongo = new Mongo("localhost", 27017);  
			DB db = mongo.getDB("doctorRegistrationdb"); 
			DBCollection collection = db.getCollection("doctorRegistrationCollection");  
			BasicDBObject andQuery = new BasicDBObject();
			List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
			obj.add(new BasicDBObject("email", email));
			obj.add(new BasicDBObject("password", password));
			andQuery.put("$and", obj);
			System.out.println(andQuery.toString());
			DBCursor cursor = collection.find(andQuery);
			while(cursor.hasNext()) {
			    System.out.println(cursor.next());
			}
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
