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
import java.util.Iterator;
import java.util.List;

import com.googlecode.jcsv.annotations.internal.ValueProcessorProvider;
import com.googlecode.jcsv.reader.CSVEntryParser;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.AnnotationEntryParser;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;

import foo.nerz.geoQuery.entity.City;



public class ImportCity1000v2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {

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

//		CSVReader<City> csvPersonReader = CSVReaderBuilder.newDefaultReader(reader);

		ValueProcessorProvider provider = new ValueProcessorProvider();
		CSVEntryParser<City> entryParser = new AnnotationEntryParser<City>(City.class, provider);
		CSVReader<City> csvPersonReader = new CSVReaderBuilder<City>(reader).entryParser(entryParser).build();

		List<City> persons = null;
		try {
			persons = csvPersonReader.readAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// read all entries at once
		

		// read each entry individually
		Iterator<City> it = csvPersonReader.iterator();
		System.out.println(persons.size());

}
}
