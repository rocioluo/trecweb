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

import javax.swing.text.html.HTMLDocument.Iterator;


/**
 * This is for INFSCI 2140 in 2015
 *
 */
public class TrectextCollection implements DocumentCollection {
	
	// YOU SHOULD IMPLEMENT THIS METHOD
	 
   
	public TrectextCollection( FileInputStream instream ) throws IOException {
		// This constructor should take an inputstream of the collection file as the input parameter.
		  //reading file line by line in Java using BufferedReader       
        FileInputStream fis = null;
        BufferedReader reader = null;
        Map<String,Object> map= new HashMap<String,Object>();
      
        try {
            fis = new FileInputStream("D://pitt//data retrieval//docset//docset.trectext");
            reader = new BufferedReader(new InputStreamReader(fis));    
            
            String line = reader.readLine();    //read in line
            String tempkey; //get the line <doc>
            String key = null; //get key
            String text = null;//get text
            
            
            while (line!= null){
            	
            line=reader.readLine();
            
                while (line.equals("<DOC>")){	                	
            	line=reader.readLine();
            	tempkey=line;
                key= tempkey.substring(8,15);                   
            break;   
            }
                
            while (line!="<TEXT>"){
            	line=reader.readLine();
            }
            
            while (line!="<TEXT>"){
                	line=reader.readLine();
                	text=line;
                	text+=text; //append text
            }
                     map.put(key,text);
                     line=reader.readLine();
                     line=reader.readLine();//read another 2 lines so that it comes to new document
            }
            Iterator iter = (Iterator) map.entrySet().iterator(); //iterate map
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
            } catch (IOException ex) {
                Logger.getLogger(TrectextCollection.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
	}
	
	// YOU SHOULD IMPLEMENT THIS METHOD
	public Map<String, Object> nextDocument() throws IOException {
		
		// Read the definition of this method from edu.pitt.sis.infsci2140.index.DocumentCollection interface 
		// and follow the assignment instructions to implement this method.
		Map map2 = new HashMap(); 
		if(iter.hasNext()) { 
 		    Map.Entry entry = (Map.Entry) iter.next(); 
 		    Object key = entry.getKey(); 
 		    Object val = entry.getValue(); 
 		    //text:stringto char
		
		
		return null;
	}
	
}
}
