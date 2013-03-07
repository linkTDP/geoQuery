package foo.nerz.geoQuery;

import org.geonames.Toponym;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;

public class Test {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 WebService.setUserName("nerz");
		 
		 
		 ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
		  searchCriteria.setQ("city");
		  searchCriteria.setMaxRows(1000);
		  ToponymSearchResult searchResult=null;
		try {
			searchResult = WebService.search(searchCriteria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=0;
		  for (Toponym toponym : searchResult.getToponyms()) {
			  i++;
		     System.out.println(toponym.getName()+" "+ toponym.getCountryName());
		  }
		  System.out.println(i);
		  searchCriteria.setStartRow(7000);
		  searchResult=null;
			try {
				searchResult = WebService.search(searchCriteria);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			  for (Toponym toponym : searchResult.getToponyms()) {
				  i++;
			     System.out.println(toponym.getName()+" "+ toponym.getCountryName());
			  }
	}

}
