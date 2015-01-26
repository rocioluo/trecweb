package edu.pitt.sis.infsci2140.index;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;


/**
 * This is for INFSCI 2140 in 2015
 *
 */
public class TrecwebCollection implements DocumentCollection {
	private Iterator<Entry<String, Object>> iter2;
	// YOU SHOULD IMPLEMENT THIS METHOD
	public TrecwebCollection( FileInputStream instream ) throws IOException {
		// This constructor should take an inputstream of the collection file as the input parameter.
		        Map<String,Object> map= new HashMap<String,Object>();
		        BufferedReader reader = new BufferedReader(new InputStreamReader(instream));                
	            String line;    //read in line
	            String tempkey; //get the line <doc>
	            String key = ""; //get key
	            String text ="";//get text
	            while ((line= reader.readLine()) != null){
	            	int flag=0;
		            while (!line.equals("<DOC>")){
		            	if((line= reader.readLine()) == null)
		            	{
		            		flag=1;
		            		break;
		            	}
		            	line=reader.readLine();
		            }
		            if(flag==1)
		            {
		            	break;
		            }
		            while (line.equals("<DOC>"))
		            {	   
		            	line=reader.readLine();
		            	line.replaceAll("<script[^>]*?>[£Ü£Üs£Ü£ÜS]*?<£Ü£Ü/script>", "");
		            	line.replaceAll("<[£Ü£Üs]*?style[^>]*?>[£Ü£Üs£Ü£ÜS]*?<[£Ü£Üs]*?£Ü£Ü/[£Ü£Üs]*?style[£Ü£Üs]*?>", "");
		            	line.replaceAll("</?(?!/?p)[^>]*>", "");//replace script, style and others exept p
		            	tempkey=line;
			            key= tempkey.substring(8,22);//docno
			            //break;   
		            } 
		            while (!line.equals("<P>")){
		            	line=reader.readLine();
		            }
		            line=reader.readLine();
		            while (!line.equals("</P>")){
		            	text+=line; 
		            	line=reader.readLine();
		            }
		            map.put(key,text.toCharArray());
		            text="";
	            }
	            iter2 = (Iterator) map.entrySet().iterator(); //iterate map
	
}
	// YOU SHOULD IMPLEMENT THIS METHOD
	public Map<String, Object> nextDocument() throws IOException {
		// Read the definition of this method from edu.pitt.sis.infsci2140.index.DocumentCollection interface 
		// and follow the assignment instructions to implement this method.
		Map<String,Object> map2 = new HashMap<String,Object>(); 
		if(iter2.hasNext()) { 
			Entry<String, Object> entry = (Entry<String, Object>) iter2.next();
			map2.put("DOCNO", entry.getKey());
			map2.put("CONTENT", entry.getValue());
			return map2;
		}
		return null;
	}
	
}