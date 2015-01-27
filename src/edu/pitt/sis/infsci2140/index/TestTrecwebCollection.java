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
 */

public class TestTrecwebCollection implements DocumentCollection {
	private Iterator<Entry<String, Object>> iter2;
	// YOU SHOULD IMPLEMENT THIS METHOD
	public TestTrecwebCollection( FileInputStream instream ) throws IOException {
		// This constructor should take an inputstream of the collection file as the input parameter.
		        Map<String,Object> map= new HashMap<String,Object>();
		        BufferedReader reader = new BufferedReader(new InputStreamReader(instream));                
	            String line;    //read in line
	            String tempkey; //get the line <doc>
	            String key = ""; //get key
	            String text ="";//get text	  
	            line= reader.readLine() ;
	            while (!line.equals("</DOC>")){
	            	//System.out.println(line);//output line=<DOC>	            	
	            		line=reader.readLine();
	            		text+=line;
	            		System.out.println(text);
	            		text=""; 
	            }
	            //map.put(key,text.toCharArray());	            
	            line=reader.readLine();
	}
	public Map<String, Object> nextDocument() throws IOException {
		// Read the definition of this method from edu.pitt.sis.infsci2140.index.DocumentCollection interface 
		// and follow the assignment instructions to implement this method.
		Map<String,Object> map2 = new HashMap<String,Object>(); 
		if(iter2.hasNext()) { 
			Entry<String, Object> entry = (Entry<String, Object>) iter2.next();
			//map2.put("DOCNO", entry.getKey());
			map2.put("CONTENT", entry.getValue());
			return map2;
		}
		return null;
	}
	
	
	public static void main(String args[]) throws IOException {
		String path_input = "data/docset.trecweb";
		TestTrecwebCollection tc=new TestTrecwebCollection(new FileInputStream(path_input));
		System.out.println("done");
//		System.out.println(tc.nextDocument().get("DOCNO"));
//		System.out.println(tc.nextDocument().get("DOCNO"));	
	}
}         