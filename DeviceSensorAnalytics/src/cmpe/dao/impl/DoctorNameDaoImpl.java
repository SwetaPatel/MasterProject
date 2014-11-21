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

public class DoctorNameDaoImpl {
	
	public List<String> dList() { 
		List<String> li = new ArrayList<String>();
//		DoctorLogin pl = (DoctorLogin) object;
//		String email = pl.getEmail();
//		String password = pl.getPassword();
		try { 
			@SuppressWarnings("deprecation")
			Mongo mongo = new Mongo("localhost", 27017);  
			DB db = mongo.getDB("dPlist"); 
			DBCollection collection = db.getCollection("dPListCollection");  
			BasicDBObject allQuery = new BasicDBObject();
			BasicDBObject fields = new BasicDBObject();
			fields.put("demail", 1);
			DBCursor cursor = collection.find(allQuery, fields);
			while(cursor.hasNext()) {
				String a = cursor.next().toString();
				li.add(a);
				System.out.println(cursor.next());
			}
			System.out.println("Done");
			System.out.println(li);
		} catch (UnknownHostException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} catch (MongoException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		}
		return li;
	} 
}
