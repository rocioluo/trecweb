package edu.pitt.sis.infsci2140.analysis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * This is for INFSCI 2140 in 2015
 * 
 */
public class StopwordsRemover {
	private HashSet<String> hashset = null;
	// YOU MUST IMPLEMENT THIS METHOD
	public StopwordsRemover( FileInputStream instream ) throws IOException {
		// load and store the stop words from the fileinputstream with appropriate data structure
		// that you believe is suitable for matching stop words.
		String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(instream));    
       hashset=new HashSet<String>();
        while ((line= reader.readLine()) != null){            	
            	hashset.add(line);
            	line=reader.readLine();
            	//System.out.println(hashset);
        }
	}
	
	// YOU MUST IMPLEMENT THIS METHOD
	public boolean isStopword( char[]word ) {
		// return true if the input word is a stop word, or false if not
		//equal
		String stopword= new String(word);
		if(hashset.contains(stopword))		
			    	return true;
			return false;
			
	}

}