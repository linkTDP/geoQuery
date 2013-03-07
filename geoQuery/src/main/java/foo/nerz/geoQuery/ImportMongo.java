package foo.nerz.geoQuery;

import foo.nerz.geoQuery.entity.City;
import foo.nerz.geoQuery.mongo.ConsolidateCity;
import foo.nerz.geoQuery.mongo.ImportCityFromFile;
import foo.nerz.geoQuery.mongo.ImportCountryFromWebService;

public class ImportMongo {

	static ImportCityFromFile cityFile;
	static ImportCountryFromWebService importCountry;
	static ConsolidateCity consolidateCity;
	public static void main(String[] args) {
		
		importCountry=new ImportCountryFromWebService();
		importCountry.importCountry();
		
		cityFile = new ImportCityFromFile();
		cityFile.addcity();
		
		consolidateCity=new ConsolidateCity(); 
		consolidateCity.consolidate();
		
	}

}
