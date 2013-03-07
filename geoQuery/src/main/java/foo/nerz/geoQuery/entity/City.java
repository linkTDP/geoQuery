package foo.nerz.geoQuery.entity;

import com.googlecode.jcsv.annotations.MapToColumn;

public class City {
	@MapToColumn(column=0)
	Integer geonameid;         // integer id of record in geonames database
	@MapToColumn(column=1)
	String name ;             // name of geographical point (utf8) varchar(200)
	@MapToColumn(column=2)
	String  asciiname;         // name of geographical point in plain ascii characters, varchar(200)
	@MapToColumn(column=3)
	String alternatenames;    // alternatenames, comma separated varchar(5000)
	@MapToColumn(column=4)
	Float latitude;          // latitude in decimal degrees (wgs84)
	@MapToColumn(column=5)
	Float longitude;         // longitude in decimal degrees (wgs84)
	@MapToColumn(column=6)
	String featureClass;     // see http////www.geonames.org/export/codes.html, char(1)
	@MapToColumn(column=7)
	String featureCode;      // see http////www.geonames.org/export/codes.html, varchar(10)
	@MapToColumn(column=8)
	String countryCode;      // ISO-3166 2-letter country code, 2 characters
	@MapToColumn(column=9)
	String  cc2;               // alternate country codes, comma separated, ISO-3166 2-letter country code, 60 characters
	@MapToColumn(column=10)
	String admin1Code;       // fipscode (subject to change to iso code), see exceptions below, see file admin1Codes.txt for display names of this code; varchar(20)
	@MapToColumn(column=11)
	String admin2Code;       // code for the second administrative division, a county in the US, see file admin2Codes.txt; varchar(80) 
	@MapToColumn(column=12)
	String admin3Code;       // code for third level administrative division, varchar(20)
	@MapToColumn(column=13)
	String admin4Code;       // code for fourth level administrative division, varchar(20)
	@MapToColumn(column=14)
	Long population;        // bigint (8 byte int) 
	@MapToColumn(column=15)
	String elevation;         // in meters, integer
	@MapToColumn(column=16)
	String  dem;               // digital elevation model, srtm3 or gtopo30, average elevation of 3''x3'' (ca 90mx90m) or 30''x30'' (ca 900mx900m) area in meters, integer. srtm processed by cgiar/ciat.
	@MapToColumn(column=17)
	String  timezone;          // the timezone id (see file timeZone.txt) varchar(40)
	@MapToColumn(column=18)
	String modificationDate; // date of last modification in yyyy-MM-dd format
	public Integer getGeonameid() {
		return geonameid;
	}
	public void setGeonameid(Integer geonameid) {
		this.geonameid = geonameid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAsciiname() {
		return asciiname;
	}
	public void setAsciiname(String asciiname) {
		this.asciiname = asciiname;
	}
	public String getAlternatenames() {
		return alternatenames;
	}
	public void setAlternatenames(String alternatenames) {
		this.alternatenames = alternatenames;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public String getFeatureClass() {
		return featureClass;
	}
	public void setFeatureClass(String featureClass) {
		this.featureClass = featureClass;
	}
	public String getFeatureCode() {
		return featureCode;
	}
	public void setFeatureCode(String featureCode) {
		this.featureCode = featureCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCc2() {
		return cc2;
	}
	public void setCc2(String cc2) {
		this.cc2 = cc2;
	}
	public String getAdmin1Code() {
		return admin1Code;
	}
	public void setAdmin1Code(String admin1Code) {
		this.admin1Code = admin1Code;
	}
	public String getAdmin2Code() {
		return admin2Code;
	}
	public void setAdmin2Code(String admin2Code) {
		this.admin2Code = admin2Code;
	}
	public String getAdmin3Code() {
		return admin3Code;
	}
	public void setAdmin3Code(String admin3Code) {
		this.admin3Code = admin3Code;
	}
	public String getAdmin4Code() {
		return admin4Code;
	}
	public void setAdmin4Code(String admin4Code) {
		this.admin4Code = admin4Code;
	}
	public Long getPopulation() {
		return population;
	}
	public void setPopulation(Long population) {
		this.population = population;
	}
	public String getElevation() {
		return elevation;
	}
	public void setElevation(String elevation) {
		this.elevation = elevation;
	}
	public String getDem() {
		return dem;
	}
	public void setDem(String dem) {
		this.dem = dem;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	
	
	
	
	
}
