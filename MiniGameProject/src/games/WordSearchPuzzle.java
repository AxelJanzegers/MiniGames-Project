package games;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import display.Grid;

public class WordSearchPuzzle {
	
	Grid g;
	File f;
	public Scanner sc = new Scanner(System.in);
	String[] words;
	
	public WordSearchPuzzle() {
		selectGrid();
		g = new Grid(11,10,f);	
		setWords();
		
	}
	
	public void selectGrid() {
		System.out.println("Choisissez la grille 1, 2 ou 3");
		int choix =sc.nextInt();
		if(choix==1) {
			f = new File("MotsMeles/Fruits.txt");
		}
	}
	
	public void setWords() {
		try{
			FileInputStream fis= new FileInputStream(f);
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			String firstLine = br.readLine().toUpperCase();
			words=firstLine.split("-");
			br.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public void dispWords() {
		for(int i=0; i<words.length;i++) {
			System.out.print(words[i]+" ");
		}
	}
	
	public void startGame() {
		g.displayGridWSP();
		System.out.println("\nMots à trouver : ");
		dispWords();
	}
	
}
