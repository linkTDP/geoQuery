package foo.nerz.geoQuery.mongo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.util.JSON;

public class ImportCountryFromWebService {
	 
	// http://localhost:8080/RESTfulExample/json/product/get
	public void importCountry() {
 
		System.out.println("Contact the Web service");
		
		JsonParser parser = new JsonParser();
	  try {
 
		URL url = new URL("http://api.geonames.org/countryInfoJSON?username=nerz");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
 
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
 
		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
 

		
		JsonArray jsonArray = parser.parse( br).getAsJsonObject().getAsJsonArray("geonames");
        
		MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
		
		DB database = client.getDB("mapper");
		
		DBCollection collection = database.getCollection("country");
		
		collection.drop();
		
        for(int i=0;i < jsonArray.size();i++){
        	System.out.println(jsonArray.get(i).toString());
        	DBObject dbObject = (DBObject) JSON.parse(jsonArray.get(i).toString());
        	collection.insert(dbObject);
        }
        
        
 
		conn.disconnect();
		
		
		

		System.out.println("Insertion on the DB mapper of collection cotry finisched");
		
 
	  } catch (MalformedURLException e) {
 
		e.printStackTrace();
 
	  } catch (IOException e) {
 
		e.printStackTrace();
 
	  }
 
	}
 
}
