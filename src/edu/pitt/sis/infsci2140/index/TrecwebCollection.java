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
	            	System.out.println(line);
	            	boolean flag=true;
		           // while (!line.equals("<DOC>")){
		            //	if((line= reader.readLine()) == null)
		            	//{
		            		//flag=true;
		            	//}
		            	//line=reader.readLine();
		           // }
		           // if(flag=false)
		            //{
		            	//break;
		            //}
		         if(line.equals("<DOC>"))
		            {
		        	    flag=true;
		            	line=reader.readLine();
		            	tempkey=line;
			            key= tempkey.substring(7,19);//docno
			            if(!line.equals("</DOC>"))
			            {
		            	  text+=line; 
		            	  line=reader.readLine();
		            	}
//		            	line = line.replaceAll("<script[^>]*?>[£Ü£Üs£Ü£ÜS]*?<£Ü£Ü/script>", "");
//		            	line = line.replaceAll("<[£Ü£Üs]*?style[^>]*?>[£Ü£Üs£Ü£ÜS]*?<[£Ü£Üs]*?£Ü£Ü/[£Ü£Üs]*?style[£Ü£Üs]*?>", "");
//		            	line = line.replaceAll("</?(?!/?p)[^>]*>", "");//replace script, style and others exept p
		            	
			            //break;   
		            }
//		         else
//		         {
//		        	 flag=false;
//		        	 break;	        	 
//		         }
//		            while (!line.equals("<P>")){
//		            	line=reader.readLine();
//		            }
//		            line=reader.readLine();
//		            while (!line.equals("</P>")){
//		            	text+=line; 
//		            	line=reader.readLine();
//		            }
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
	
	
	public static void main(String args[]) throws IOException {
		String path_input = "data/docset.trecweb";
		TrecwebCollection tc = new TrecwebCollection(new FileInputStream(path_input));
		System.out.println(tc.nextDocument().get("DOCNO"));
		System.out.println(tc.nextDocument().get("DOCNO"));
		System.out.println(tc.nextDocument().get("DOCNO"));
		System.out.println(tc.nextDocument().get("DOCNO"));
		
	}
}