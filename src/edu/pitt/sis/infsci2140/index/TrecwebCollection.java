package edu.pitt.sis.infsci2140.index;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * This is for INFSCI 2140 in 2015
 *
 */
public class TrecwebCollection implements DocumentCollection {
	
	// YOU SHOULD IMPLEMENT THIS METHOD
	public TrecwebCollection( FileInputStream instream ) throws IOException {
		// This constructor should take an inputstream of the collection file as the input parameter.
		  FileInputStream fis = null;
	        BufferedReader reader = null;
	        Map<String,Object> map= new HashMap<String,Object>();
	        try {
	            fis = new FileInputStream("D://pitt//data retrieval//docset//docset.trectweb");
	            reader = new BufferedReader(new InputStreamReader(fis));    
	            String line = reader.readLine(); 
	            line=line.replaceAll("<script[^>]*?>[£Ü£Üs£Ü£ÜS]*?<£Ü£Ü/script>", "");
	            line=line.replaceAll("<[£Ü£Üs]*?style[^>]*?>[£Ü£Üs£Ü£ÜS]*?<[£Ü£Üs]*?£Ü£Ü/[£Ü£Üs]*?style[£Ü£Üs]*?>", "");
	            line=line.replaceAll("</?(?!/?p)[^>]*>", "");
	            String tempkey;
	            String key = null;
	            String text = null;
	            
	            
	            while (line!= null){
	            	
	            line=reader.readLine();
	            
	                while (line.equals("<DOC>")){	                	
	            	line=reader.readLine();
	            	tempkey=line;
	                key= tempkey.substring(8,15);                   
	            break;   
	            }
	                
	            while (line!="<p>"){
	            	line=reader.readLine();
	            }
	            
	            while (line!="</p>"){
	                	line=reader.readLine();
	                	text=line;
	                	text+=text;
	            }
	                     map.put(key,text);
	                     line=reader.readLine();
	                     line=reader.readLine();
	            }
	            Iterator iter = (Iterator) map.entrySet().iterator(); 
	           // Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
	    	
	    		
	            
	        }

	                
	          
	          
	        catch (FileNotFoundException ex) {
	            Logger.getLogger(TrectextCollection.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IOException ex) {
	            Logger.getLogger(TrectextCollection.class.getName()).log(Level.SEVERE, null, ex);
	          
	        } 
	        finally {
	            try {
	                reader.close();
	                fis.close();
	            } catch (IOException ex) {
	                Logger.getLogger(TrectextCollection.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        
	        }
	}
	
	// YOU SHOULD IMPLEMENT THIS METHOD
	public Map<String, Object> nextDocument() throws IOException {
		// Read the definition of this method from edu.pitt.sis.infsci2140.index.DocumentCollection interface 
		// and follow the assignment instructions to implement this method.
		return null;
	}
	
}
//regx html method