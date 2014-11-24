package cmpe.dao.impl;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.json.simple.JSONArray;

import cmpe.entity.ReportGeneration;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class ReportGenerationDaoImpl {
	public String reportGen(Object object) { 
		ReportGeneration pl = (ReportGeneration) object;
		String email = pl.getPemail();
		JSONObject mainObj = new JSONObject();
		try { 
			
			Mongo mongo = new Mongo("localhost", 27017);  
			DB db = mongo.getDB("healthdb"); 
			DBCollection collection = db.getCollection("healthCollection");  
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("pemail", email);
			DBCursor cursor = collection.find(whereQuery);
			JSONArray ja = new JSONArray();
			while(cursor.hasNext()) {
			    DBObject o = cursor.next();
			    String timestampVal = o.get("timestampVal").toString();
				String highBp = o.get("highBp").toString();
				String lowBp = o.get("lowBp").toString();
				String bpm = o.get("bpm").toString();
				JSONObject jo = new JSONObject();
				jo.put("timestampVal", timestampVal);
				jo.put("highBp", highBp);
				jo.put("lowBp", lowBp);
				jo.put("bpm", bpm);
				ja.add(jo);
				mainObj.put("data", ja);
			}
			System.out.println("Done");
		} catch (UnknownHostException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} catch (MongoException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		}
		return mainObj.toString();
	} 
}
