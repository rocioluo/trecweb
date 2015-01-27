package edu.pitt.sis.infsci2140.analysis;

/**
 * This is for INFSCI 2140 in 2015
 * 
 * TextTokenizer can split a sequence of text into individual word tokens.
 */
public class TextTokenizer {
	
	public String[]words;
	// YOU MUST IMPLEMENT THIS METHOD
	public TextTokenizer( char[] texts ) {
		// this constructor will tokenize the input texts (usually it is a char array for a whole document)
		for(int i=0;i <texts.length;i++){//get all text
		String temp=String.valueOf(texts);//get value
		words=temp.split(" ");//split value
		}
	}
	
	// YOU MUST IMPLEMENT THIS METHOD
	public char[] nextWord() {
		// read and return the next word of the document; or return null if it is the end of the document
		
		return null;
	}
	
}
