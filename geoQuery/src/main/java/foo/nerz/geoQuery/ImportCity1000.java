package foo.nerz.geoQuery;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import foo.nerz.geoQuery.entity.City;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class ImportCity1000 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
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
		
		CSVReader readerr = new CSVReader(reader,'\t');
	    String [] nextLine;
	    int i = 0;
	    
	    while ((nextLine = readerr.readNext()) != null) {
	        // nextLine[] is an array of values from the line
//	    	String value = URLEncoder.encode(nextLine[1], "UTF-8");
	    	
//	    	System.out.println(nextLine[0] + " - " + nextLine[1] + " - " + nextLine[2] + " - "+ nextLine[3] + " - "+ nextLine[4] + " - "+ nextLine[5] + " - "+ nextLine[6] + " - "+ nextLine[7] + " - "+ nextLine[8] + " - "+ nextLine[9] + " - "+ nextLine[10] + " - "+ nextLine[11] + " - "+ nextLine[12] + " - "+ nextLine[13] + " - "+ nextLine[14] + " - "+ nextLine[15] + " - "+ nextLine[16] + " - "+ nextLine[17] + " - "+ nextLine[18] + " - ");
	        
	        i++;
	    }
	    
//	    ColumnPositionMappingStrategy<City> strat = new ColumnPositionMappingStrategy<City>();
//	    strat.setType(City.class);
//	    String[] columns = new String[] {"geonameid", "name", "asciiname", "alternatenames", "latitude", "longitude", "featureClass", "featureCode", "countryCode", "cc2", "admin1Code", "admin2Code", "admin3Code", "admin4Code", "population", "elevation", "dem", "timezone", "modificationDate"}; // the fields to bind do in your JavaBean
//	    strat.setColumnMapping(columns);
//
//	    CsvToBean<City> csv = new CsvToBean<City>();
//	    List<City> list = csv.parse(strat, reader);
//	    
//	    System.out.println(list.size());
	    
	    
	    System.out.println(i);
	}

}
