package edu.pitt.sis.infsci2140;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

import edu.pitt.sis.infsci2140.index.TrecwebCollection;
import edu.pitt.sis.infsci2140.index.TrectextCollection;
import edu.pitt.sis.infsci2140.index.DocumentCollection;
import edu.pitt.sis.infsci2140.analysis.TextTokenizer;
import edu.pitt.sis.infsci2140.analysis.TextNormalizer;
import edu.pitt.sis.infsci2140.analysis.StopwordsRemover;

/**
 * !!! YOU CANNOT CHANGE ANYTHING IN THIS CLASS !!!
 * This is for INFSCI 2140 in 2015
 * 
 * Main class for running your HW1.
 * 
 */
public class text {
	public static void main(String[] args) {
		
		String flag="text";
		String format = "trec"+flag;
		String path_input = "data/docset.trec"+flag;
		String path_output = "data/result"+flag+".txt";
		String path_stopwords = "data/stopwords.txt";
		System.out.println(format+" "+path_input+" "+path_stopwords+" "+path_output);
		
		FileInputStream instream_collection = null;
		DocumentCollection collection = null;
		
		try{
			// Loading the collection file and initiate the DocumentCollection class
			instream_collection = new FileInputStream(path_input);
			if( format.equalsIgnoreCase("trectext") ) {
				collection = new TrectextCollection(instream_collection);
			}else if( format.equalsIgnoreCase("trecweb") ) {
				collection = new TrecwebCollection(instream_collection);
			}
		}catch(IOException e){
			System.out.println("ERROR: cannot load collection file.");
			e.printStackTrace();
		}
		
		FileInputStream instream_stopwords = null;
		StopwordsRemover stoprmv = null;
		
		try{
			// Loading the stopword list file and initiate the StopwordsRemover class
			instream_stopwords = new FileInputStream(path_stopwords);
			stoprmv = new StopwordsRemover(instream_stopwords);
		}catch(IOException e){
			System.out.println("ERROR: cannot load stopwords file.");
			e.printStackTrace();
		}
		
		BufferedWriter output = null;
		
		try {
			// Initiate the output writer ...
			output = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(path_output), "UTF-8" ) );
		}catch(IOException e){
			System.out.println("ERROR: cannot initiate output file.");
			e.printStackTrace();
		}
		
		if( collection!=null && stoprmv!=null && output!=null ) {
			
			try{
				
				Map<String,Object> doc = null;
				while( ( doc=collection.nextDocument() ) != null ) { // iteratively reading each document from the collection
					
					String docno = (String) doc.get("DOCNO"); // load docno of the document and output
					char[] content = (char[]) doc.get("CONTENT"); // document content
					
					output.write(docno);
					output.write("\n");
					
					TextTokenizer tokenizer = new TextTokenizer(content);
					char[] word = null;
					while( ( word=tokenizer.nextWord() ) != null ) { // iteratively loading each word from the document
						word = TextNormalizer.normalize(word); // normalize each word
						if( stoprmv.isStopword(word) ) {
							// if the word is a stopword, output <OOV> (Out Of Vocabulary)
							output.write("<OOV>");
						}else{
							// if the word is not a stopword, output the normalized word
							output.write(word);
						}
						output.write(" "); // each normalized word will be separated by a whitespace
					}
					output.write("\n");
					
				}
				
			}catch(IOException e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
		}
		
		if( instream_collection!=null ) {
			try{
				instream_collection.close();
			}catch(IOException e){ }
		}
		
		if( instream_stopwords!=null ) {
			try{
				instream_stopwords.close();
			}catch(IOException e){ }
		}
		
		if( output!=null ) {
			try{
				output.close();
			}catch(IOException e){ }
		}
		
	}
	
}
