package cmpe.dao.impl;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import cmpe.entity.ReportGeneration;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class ReportGenerationDaoImpl {
	public String reportGen(Object object) { 
		ReportGeneration pl = (ReportGeneration) object;
		String pemail = pl.getPemail();
		List<String> li = new ArrayList<String>();
		try { 
			
			Mongo mongo = new Mongo("localhost", 27017);  
			DB db = mongo.getDB("healthdb"); 
			DBCollection collection = db.getCollection("healthCollection");  
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("pemail", pemail);
			DBCursor cursor = collection.find(whereQuery);
			while(cursor.hasNext()) {
			    System.out.println(cursor.next());
			    li.add(cursor.next().toString());
			}
			System.out.println(li);
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
