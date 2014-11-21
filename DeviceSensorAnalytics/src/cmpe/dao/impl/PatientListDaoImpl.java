package cmpe.dao.impl;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import cmpe.entity.PatientList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class PatientListDaoImpl {
	public List<String> pList(Object object) { 
		List<String> li = new ArrayList<String>();
		PatientList pl = (PatientList) object;
		String demail = pl.getDemail();
//		String password = pl.getPassword();
		try { 
			@SuppressWarnings("deprecation")
			Mongo mongo = new Mongo("localhost", 27017);  
			DB db = mongo.getDB("dPlist"); 
			DBCollection collection = db.getCollection("dPListCollection");  
			BasicDBObject allQuery = new BasicDBObject();
			BasicDBObject fields = new BasicDBObject();
			fields.put("demail", demail);
			DBCursor cursor = collection.find(allQuery, fields);
			while(cursor.hasNext()) {
				String a = cursor.next().toString();
				li.add(a);
				System.out.println(cursor.next());
			}
			System.out.println("Done patient list for a doctor");
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
