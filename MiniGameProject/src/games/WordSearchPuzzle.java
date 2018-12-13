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
	
	private Grid g; //Grille des mots meles
	private File f; //Fichier contenant la grille
	public Scanner sc = new Scanner(System.in);
	private String[] words;
	private String answer;
	private char[] Tbeg;
	private char[] Tend;
	
	
	public WordSearchPuzzle(File f) {
		this.f=f;
		g = new Grid(11,10,f);
		setWords();
		
	}
	
	
	/*
	 * Selection de la grille
	 */
	public void selectGrid() { 
		System.out.println("Choisissez la grille 1, 2 ou 3");
		int choix =sc.nextInt();
				do {
					switch(choix) {
					case 1 :
						f = new File("MotsMeles/Fruits.txt");
						break;
					case 2 : 
						f = new File("MotsMeles/Fruits.txt");
						break;
					case 3 :
						f = new File("MotsMeles/Fruits.txt");
						break;
					default:
						System.out.println("Choisissez la grille 1, 2 ou 3");
					}
				} while (choix <1 || choix >= 4);
		}
	
	
	/*
	 * Initialise les mots à trouver
	 */
	
	public String[] getWords() {
		return words;
	}


	public void setWords(String[] words) {
		this.words = words;
	}


	public Grid getG() {
		return g;
	}


	public void setG(Grid g) {
		this.g = g;
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
	
	/*
	 * Affiche les mots à trouver
	 */
	public void dispWords() {
		for(int i=0; i<words.length;i++) {
			System.out.print(words[i]+" ");
		}
	}
	
	
	
	/*
	 * Obtient le mot défini par les coordonnées entrées par l'user
	 */
	public void makeWord(String beginning, String end) {
		Tbeg=beginning.toCharArray();
		Tend=end.toCharArray();
		System.out.println(Tbeg[1]);
		System.out.println(g.getTab()[g.letterToInt(Tbeg[0])][2]);
	}
	
	/*
	 * DEMARRAGE DU JEU
	 */
	public void startGame() {
		selectGrid();
		g = new Grid(11,10,f);	
		setWords();
		
		String beg, end; //Variables utilisées pour stocker les coordonnées de la première et dernière case d'un mot
		g.displayGridWSP(); //Affichage de la grille
		
		System.out.println("\nMots à trouver : ");
		dispWords();
		
		System.out.println("\nEntrez les coordonnées de la première lettre du mot à trouver (ex : A3, B2...) : ");
		beg = sc.nextLine().toUpperCase();
		System.out.println("\nEntrez les coordonnées de la dernière lettre du mot à trouver (ex : E3, B7...) : ");
		end = sc.nextLine().toUpperCase();
		makeWord(beg, end);
		
	}
	
}
