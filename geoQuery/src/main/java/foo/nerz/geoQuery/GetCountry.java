package foo.nerz.geoQuery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.jena.atlas.json.JsonObject;

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

public class GetCountry {
	 
	// http://localhost:8080/RESTfulExample/json/product/get
	public static void main(String[] args) {
 
		
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
 
//		String output;
//		System.out.println("Output from Server .... \n");
//		while ((output = br.readLine()) != null) {
//			System.out.println(output);
//		}
		
		JsonArray jsonArray = parser.parse( br).getAsJsonObject().getAsJsonArray("geonames");
//        com.google.gson.JsonObject jsonObject = jsonArray.getAsJsonObject();
//        System.out.println(jsonArray.toString());
        
		MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
		
		DB database = client.getDB("mapper");
		
		DBCollection collection = database.getCollection("country");
		
        for(int i=0;i < jsonArray.size();i++){
        	System.out.println(jsonArray.get(i).toString());
        	DBObject dbObject = (DBObject) JSON.parse(jsonArray.get(i).toString());
        	collection.insert(dbObject);
        }
        
        
 
		conn.disconnect();
		
		
		
		DBCursor cursorDoc = collection.find();
		while (cursorDoc.hasNext()) {
			System.out.println(cursorDoc.next());
		}

		System.out.println("Done");
		
 
	  } catch (MalformedURLException e) {
 
		e.printStackTrace();
 
	  } catch (IOException e) {
 
		e.printStackTrace();
 
	  }
 
	}
 
}
