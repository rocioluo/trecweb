package edu.pitt.sis.infsci2140.analysis;

/**
 * This is for INFSCI 2140 in 2015
 * 
 */
public class TextNormalizer {
	
	// YOU MUST IMPLEMENT THIS METHOD
	public static char[] normalize( char[] chars ) {
		// return the normalized version of the word characters (replacing all uppercase characters into the corresponding lowercase characters)
		//get text words
		//String characters = (SecondTextField.getText()); //String to read the user input
       // int length = characters.length();  //change the string characters to length

     for(int i = 0; i < length; i++)  //to check the characters of string..
     {             
        char character = characters.charAt(i);          

        if(Character.isUpperCase(character)) 
        {
           // SecondTextField.setText("" + characters.toLowerCase());

        }
        else  
        {
            continue;
            }               
     }   
		return chars;
	}
	
}
