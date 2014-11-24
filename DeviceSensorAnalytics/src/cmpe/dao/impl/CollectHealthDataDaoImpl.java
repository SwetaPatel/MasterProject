package cmpe.dao.impl;

import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;

import cmpe.entity.CollectHealthData;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class CollectHealthDataDaoImpl {

	public String collectData(Object object) {
//		Date date = new Date();
		CollectHealthData pr = (CollectHealthData) object;
		String highBp = pr.getHighBp();
		String lowBp = pr.getLowBp();
		String bpsReading = pr.getBpsReading();
		String pemail = pr.getPemail();
		Date dateVal = new Date();
		System.out.println("aa1");
		try { 
			Mongo mongo = new Mongo("localhost", 27017);  
			DB db = mongo.getDB("healthdb"); 
			System.out.println("aa");
			DBCollection collection = db.getCollection("healthCollection");  
			BasicDBObject document = new BasicDBObject(); 
			System.out.println("aa");
			document.put("pemail", pemail);  
			document.put("highBp", highBp);  
			document.put("lowBp", lowBp);  
			document.put("bps", bpsReading);  
			document.put("timestampVal", dateVal);     
			System.out.println("aa");
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

