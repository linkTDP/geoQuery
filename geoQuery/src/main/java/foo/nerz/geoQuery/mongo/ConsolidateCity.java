package foo.nerz.geoQuery.mongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class ConsolidateCity {

	/**
	 * @param args
	 */
	public void consolidate() {
		


		MongoClient client = null;
		try {
			client = new MongoClient(new ServerAddress("localhost", 27017));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DB database = client.getDB("mapper");

		DBCollection collection = database.getCollection("city");

		DBCursor obj=collection.find();
		int index=0;
		try{
			while(obj.hasNext()){
				DBObject cu=obj.next();
//				System.out.println(index);
				index++;
				Object t=cu.get("alternativeName");
				String cuu=null;

				if(t instanceof String ){
					cuu=(String) t;
				}else{
					System.out.println(cu.get("_id"));
				}

				if(cuu!=null){


					System.out.println(cuu);
					ArrayList<String> lista=new ArrayList<String>();
					String tmp="";
					for(int i=0; i<cuu.length(); i++){

						if(!cuu.substring(i, i+1).contains(",")){
							//					System.out.print(cuu.substring(i, i+1));
							tmp=tmp+cuu.substring(i, i+1);
							if(i==cuu.length()-1){
								if(Pattern.matches("[a-zA-Z\\sAa\u00C0-\u00C6\u00E0-\u00E6-]+", tmp))lista.add(tmp);
							}
						}else{
							if(Pattern.matches("[a-zA-Z\\sAa\u00C0-\u00C6\u00E0-\u00E6-]+", tmp))lista.add(tmp);
							tmp="";
						}
					}

					//			System.out.println();
					//			for(String cur : lista){
					//				
					//				System.out.println(cur);
					//			}

					Integer id=(Integer) cu.get("_id");

					BasicDBList dbl = new BasicDBList();

					for(String cur : lista){
						dbl.add(cur);
					}

					collection.update(new BasicDBObject("_id",id), new BasicDBObject("$set",new BasicDBObject("alternativeName",dbl)));
				}


			}
		}finally{
			collection.createIndex(new BasicDBObject("name", 1).append("population", -1));
			obj.close();
		}

	}

}
