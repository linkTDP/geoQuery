package foo.nerz.geoQuery;

import java.io.File;
import java.io.InputStream;


import com.hp.hpl.jena.graph.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.ResultSet;

import de.fuberlin.wiwiss.ng4j.semwebclient.SemanticWebClient;

public class TestJena {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create an empty model
//		 Model model = ModelFactory.createDefaultModel();
//
//		 String fil="C:"+File.separator+"Users"+File.separator+"Fabio"+File.separator+"Desktop"+File.separator+"bacuppare"+File.separator+"all-geonames-rdf.txt";
//		 System.out.println(fil);
//		 
//		 // use the FileManager to find the input file
//		 InputStream in = FileManager.get().open( fil );
//		if (in == null) {
//		    throw new IllegalArgumentException(
//		                                 "File:  not found");
//		}
//
//		// read the RDF/XML file
//		model.read(in, null);
//
//		// write it to standard out
//		model.write(System.out);
		
		
		
//		
//		String sparqlQueryString1= "PREFIX gnO:<http://www.geonames.org/ontology#>"+
//"SELECT ?s ?nm"+
//"{"+
//"  ?s gnO:featureCode gnO:A.PCLI ."+
//"  ?s gnO:name ?nm"+
//"}"+
//"ORDER BY ?nm";
//
//
//			      Query query = QueryFactory.create(sparqlQueryString1);
//			      QueryExecution qexec = QueryExecutionFactory.sparqlService("http://http://factforge.net/sparql", query);
//
//			      ResultSet results = qexec.execSelect();
//			      ResultSetFormatter.out(System.out, results, query);       
//
//			     qexec.close() ;
		
		// Create a new Semantic Web client.
		SemanticWebClient semweb = new SemanticWebClient(); 
		 
//		// Specify the query.
//		String queryString = 
//		"PREFIX foaf: <http://xmlns.com/foaf/0.1/> " + 
//		"SELECT DISTINCT ?i WHERE {" + 
//		"<http://www.w3.org/People/Berners-Lee/card#i> foaf:knows ?p . " + 
//		"?p foaf:interest ?i ." + 
//		"}"; 
		String a= "culo";
	
		
		String queryString= "PREFIX gnO:<http://www.geonames.org/ontology#>"+
"SELECT ?s ?nm"+
"{"+
"  ?s gnO:featureCode gnO:A.PCLI ."+
"  ?s gnO:name ?nm"+
"}"+
"ORDER BY ?nm";
		 
		// Execute the query and obtain results. 
		com.hp.hpl.jena.query.Query query = QueryFactory.create(queryString); 
		QueryExecution qe = QueryExecutionFactory.create(query, semweb.asJenaModel("default")); 
		com.hp.hpl.jena.query.ResultSet results = qe.execSelect(); 

		// Output query results.
		ResultSetFormatter.out(System.out, results, query); 
		
		
	}

}
