package edu.pitt.sis.infsci2140.index;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This is for INFSCI 2140 in 2015
 *
 */
public class TrectextCollection implements DocumentCollection {
	
	// YOU SHOULD IMPLEMENT THIS METHOD
	  

    void getdata(String args[]) {
	      
	        //reading file line by line in Java using BufferedReader       
	        FileInputStream fis = null;
	        BufferedReader reader = null;
	      
	        try {
	            fis = new FileInputStream("D://pitt//data retrieval//docset//docset.trectext");
	            reader = new BufferedReader(new InputStreamReader(fis));    
	            
	            String line = reader.readLine();    
	            String tempkey;
	            String key = null;
	            String text = null;
	            Map<String,Object> map= new HashMap<String,Object>();
	            
	            while (line!= null){
	            	
                line=reader.readLine();
                
	                while (line.equals("<DOC>")){	                	
	            	line=reader.readLine();
	            	tempkey=line;
                    key= tempkey.substring(7);                   
                break;   
                }
	                
	            while (line!="<TEXT>"){
	            	line=reader.readLine();
	            }
	            
                while (line!="<TEXT>"){
                    	line=reader.readLine();
                    	text=line;
                    	text+=text;
                }
                         map.put(key,text);
                         line=reader.readLine();
                         line=reader.readLine();
                }
	            
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
    
	public TrectextCollection( FileInputStream instream ) throws IOException {
		// This constructor should take an inputstream of the collection file as the input parameter.
		
	}
	
	// YOU SHOULD IMPLEMENT THIS METHOD
	public Map<String, Object> nextDocument() throws IOException {
		// Read the definition of this method from edu.pitt.sis.infsci2140.index.DocumentCollection interface 
		// and follow the assignment instructions to implement this method.
		
		
		return null;
	}
	
}
