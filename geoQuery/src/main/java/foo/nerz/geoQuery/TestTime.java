package foo.nerz.geoQuery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

import com.hp.hpl.jena.graph.query.Query;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.QueryBuilder;
import com.mongodb.ServerAddress;

public class TestTime {

	static int counter = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient client = null;
		try {
			client = new MongoClient(new ServerAddress("localhost", 27017));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		long startTime; 
		// ... do something ...
		long estimatedTime ;
		while(true){
			
			System.out.println("citta:");
			System.out.println();
			String s = null;
			try{
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				s = bufferRead.readLine();

				System.out.println(s);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			startTime = System.currentTimeMillis();
			

			DB database = client.getDB("mapper");

			DBCollection collection = database.getCollection("city");

			BasicDBObject query = new BasicDBObject();
			query.put("name",new BasicDBObject("$regex","^"+s));
			
			

				DBCursor cur=	collection.find(query,new BasicDBObject("name",true).append("population", true).append("countryCode", true )).sort(new BasicDBObject("population",-1)).limit(20);
		
				try{
				while(cur.hasNext()){
					BasicDBObject c=(BasicDBObject) cur.next();
					System.out.println(c);
				}}finally{
					cur.close();
				}
				
				estimatedTime = System.currentTimeMillis() - startTime;
				
				System.out.println(estimatedTime);
		}
	}

}
