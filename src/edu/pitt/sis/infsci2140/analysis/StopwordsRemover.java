package edu.pitt.sis.infsci2140.analysis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

/**
 * This is for INFSCI 2140 in 2015
 * 
 */
public class StopwordsRemover {
	
	// YOU MUST IMPLEMENT THIS METHOD
	public StopwordsRemover( FileInputStream instream ) {
		// load and store the stop words from the fileinputstream with appropriate data structure
		// that you believe is suitable for matching stop words.
		FileInputStream fis = null;
        BufferedReader reader = null;
        char[] stopword=new char[20000];//Initiate
      
        try {
            fis = new FileInputStream("D://pitt//data retrieval//stop_list.txt");
            reader = new BufferedReader(new InputStreamReader(fis));        
            String line = reader.readLine();
            
            
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }  
            for (int i =0;i<line.length();i++)
            {
            	stopword[i]=line.charAt(i);
            }//read into char array 
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StopwordsRemover.class.getName(),null).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StopwordsRemover.class.getName(),null).log(Level.SEVERE, null, ex);
          
        } finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(StopwordsRemover.class.getName(), null).log(Level.SEVERE, null, ex);
            }
        }
  } 
	
	
	// YOU MUST IMPLEMENT THIS METHOD
	public boolean isStopword( char[] word ) {
		
		// return true if the input word is a stopword, or false if not
		return false;
	}
	
}
