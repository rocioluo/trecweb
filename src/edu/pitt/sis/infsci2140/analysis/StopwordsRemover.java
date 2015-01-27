package edu.pitt.sis.infsci2140.analysis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * This is for INFSCI 2140 in 2015
 * 
 */
public class StopwordsRemover {
	char[] stopwords;
	// YOU MUST IMPLEMENT THIS METHOD
	public StopwordsRemover( FileInputStream instream ) throws IOException {
		// load and store the stop words from the fileinputstream with appropriate data structure
		// that you believe is suitable for matching stop words.
		String line;
		Map<String,Object> map= new HashMap<String,Object>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(instream));    
        while ((line= reader.readLine()) != null){
            	line=reader.readLine();
            	stopwords=line.toCharArray();
            	//System.out.println(stopwords);
        		//String  aa=String.valueOf(stopwords);
        }
	}
	
	// YOU MUST IMPLEMENT THIS METHOD
	public boolean isStopword( char[]word ) {
		// return true if the input word is a stop word, or false if not
		//equal
		for(int i=0;i<stopwords.length;i++){
				if (word.equals(stopwords[i]))
				{
			    	return true;
				}
		
			return false;
			}
		return false;
		    
		
	}

}