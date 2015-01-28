package edu.pitt.sis.infsci2140.index;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/**
 * This is for INFSCI 2140 in 2015
 */
public class TrecwebCollection implements DocumentCollection {
	private BufferedReader reader;
	// YOU SHOULD IMPLEMENT THIS METHOD
	public TrecwebCollection( FileInputStream instream ) throws IOException {
		// This constructor should take an inputstream of the collection file as the input parameter.
		        reader = new BufferedReader(new InputStreamReader(instream));                            
	}
	public Map<String, Object> nextDocument() throws IOException {
		// Read the definition of this method from edu.pitt.sis.infsci2140.index.DocumentCollection interface 
		// and follow the assignment instructions to implement this method.
		Map<String, Object> doc = new HashMap<String, Object>();//map is called doc
		String regex = "<(\\S+)[^>]+?mso-[^>]*>.*?</\\1>";
	    String replacement = "";
	    String key = ""; //get key
	    String text ="";//get text	 
	    String temptext= "";    
		String line;
		while ((line= reader.readLine()) != null){
            if(line.contains("<DOCNO>")){
            	line=text.replaceAll(regex, replacement); // prints without html tag
            key=line.substring(8,19);
            doc.put("DOCNO", key);
            break;
            }
		}
		while ((line= reader.readLine()) != null){
            if(line.contains("<DOCHDR>")){
            	line= reader.readLine();
            	line=text.replaceAll(regex, replacement); // prints without html tag
                while(!line.contains("</DOC>")){
                	temptext=temptext+line;
                	line= reader.readLine();
                }
                }
            doc.put("CONTENT", text.toCharArray());
            break;
            }
		if (doc.isEmpty()==true)
		{return null;}
		return doc;

	}
//	public static void main(String args[]) throws IOException {
//		String path_input = "data/docset.trecweb";
//		TestTrecwebCollection tc=new TestTrecwebCollection(new FileInputStream(path_input));
//		System.out.println("done");
////		System.out.println(tc.nextDocument().get("DOCNO"));
////		System.out.println(tc.nextDocument().get("DOCNO"));	
//	}
}         