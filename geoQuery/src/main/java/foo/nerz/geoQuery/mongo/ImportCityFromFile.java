package foo.nerz.geoQuery.mongo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.annotations.internal.ValueProcessorProvider;
import com.googlecode.jcsv.reader.CSVEntryParser;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.AnnotationEntryParser;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.util.JSON;

import foo.nerz.geoQuery.entity.City;

public class ImportCityFromFile {

	/**
	 * @param args
	 */
	public void addcity() {

//		CSVReader reader = new CSVReader(new FileReader("src/main/resources/city3.txt"),'\t');
		
		Reader reader = null;
		try {
			 reader = new InputStreamReader(new FileInputStream("src/main/resources/cities1000.txt"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ValueProcessorProvider provider = new ValueProcessorProvider();
		CSVEntryParser<City> entryParser = new AnnotationEntryParser<City>(City.class, provider);
		CSVReader<City> csvPersonReader = new CSVReaderBuilder<City>(reader).strategy(new CSVStrategy('\t', '\\', '#', false, true)).entryParser(entryParser).build();

		List<City> cities = null;
		try {
			cities = csvPersonReader.readAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// read all entries at once
		

		// read each entry individually
		
		System.out.println(cities.size());
		
		MongoClient client = null;
		try {
			client = new MongoClient(new ServerAddress("localhost", 27017));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DB database = client.getDB("mapper");
		
		DBCollection collection = database.getCollection("city");
		
		List<City> list = Collections.synchronizedList(new ArrayList<City>() );
		
		for(City current : cities){
			
			
			list.add(current);
		}

		System.out.println("File Readed");
		
		collection.drop();
		
		for(int i=0; i< cities.size(); i++){
			
		
			DBObject dbObject=new BasicDBObject();
			
			dbObject.put("_id", cities.get(i).getGeonameid());
			dbObject.put("name",cities.get(i).getName());
			dbObject.put("alternativeName",cities.get(i).getAlternatenames());
			dbObject.put("asciiname",cities.get(i).getAsciiname());
			dbObject.put("latitude",cities.get(i).getLatitude());
			dbObject.put("longitude",cities.get(i).getLongitude());				
			dbObject.put("featureClass",cities.get(i).getFeatureClass());
			dbObject.put("featureCode",cities.get(i).getFeatureCode());
			dbObject.put("countryCode",cities.get(i).getCountryCode());
			dbObject.put("cc2",cities.get(i).getCc2());
			dbObject.put("admin1Code",cities.get(i).getAdmin1Code());
			dbObject.put("admin2Code",cities.get(i).getAdmin2Code());
			dbObject.put("admin3Code",cities.get(i).getAdmin3Code());
			dbObject.put("admin4Code",cities.get(i).getAdmin4Code());
			dbObject.put("population",cities.get(i).getPopulation());
			dbObject.put("elevation",cities.get(i).getElevation());
			dbObject.put("dem",cities.get(i).getDem());
			dbObject.put("timezone",cities.get(i).getTimezone());
			dbObject.put("modificationDate",cities.get(i).getModificationDate());
					
			
					
					
//        	DBObject dbObject = (DBObject) JSON.parse(json);
        	collection.insert(dbObject);
        	
        	
        
		}
        
		System.out.println("City inserted in DB mapper - city collection");

	}

}
