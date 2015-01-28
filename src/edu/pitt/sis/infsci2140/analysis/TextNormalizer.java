package edu.pitt.sis.infsci2140.analysis;

/**
 * This is for INFSCI 2140 in 2015
 * 
 */
public class TextNormalizer {
	
	// YOU MUST IMPLEMENT THIS METHOD
	public static char[] normalize( char[] chars ) {
		// return the normalized version of the word characters (replacing all uppercase characters into the corresponding lowercase characters)		
		String lowchars = (new String(chars)).toLowerCase();//string.tolowercase
		return lowchars.toCharArray();
	}
	
}