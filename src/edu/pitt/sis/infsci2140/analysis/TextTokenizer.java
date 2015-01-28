package edu.pitt.sis.infsci2140.analysis;

import java.util.ArrayList;

/**
 * This is for INFSCI 2140 in 2015
 * 
 * TextTokenizer can split a sequence of text into individual word tokens.
 */
public class TextTokenizer {
	
	private ArrayList<char[]> words = null;//use arraylist to get document words
	private int i=0;
	// YOU MUST IMPLEMENT THIS METHOD
	public TextTokenizer( char[] texts ) {
		// this constructor will tokenize the input texts (usually it is a char array for a whole document)
		words =new ArrayList<char[]>();
		String tokentext=new String(texts);
		tokentext=tokentext.replace("'", "");
		String[] tokenword=tokentext.split(" ");//split value
		for(int i = 0 ; i < tokenword.length; i++)
			words.add(tokenword[i].toCharArray());
	}
	
	
	// YOU MUST IMPLEMENT THIS METHOD
	public char[] nextWord() {
		// read and return the next word of the document; or return null if it is the end of the document
		if(i== words.size())
		{return null;}
		else			
		return words.get(i++);
	}
	
}
