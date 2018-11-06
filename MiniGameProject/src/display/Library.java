package display;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public abstract class Library {

	
	public static void test(){
	File library = new File("././francais.dic");
	
	FileInputStream inFileStream;
	try {
		inFileStream = new FileInputStream(library);
		ObjectInputStream inObjectStream = new ObjectInputStream(inFileStream);
		int taille = inObjectStream.readInt();
		System.out.println(inObjectStream.readChar());
		
		inObjectStream.close();
	} 
	catch (FileNotFoundException e11) {
		e11.printStackTrace();
	} 
	catch (IOException e1) {
		e1.printStackTrace();
	} 
	}
	
	
	
}
