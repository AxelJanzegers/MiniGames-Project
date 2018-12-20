package games;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import display.Grid;
import display.Score;

public class WordSearchPuzzle {

	private Grid g; //Grille des mots meles
	private File f; //Fichier contenant la grille
	public Scanner sc = new Scanner(System.in);
	private String[] words; //tableau des mots à trouver
	private String answer; //mot entré par l'user
	private int[] beg = new int[2]; //coordonnées de la 1ère lettre du mot entré
	private int[] end = new int[2]; //coordonnées de la dernière lettre du mot entré
	private Score score = new Score();


	public WordSearchPuzzle(File f) {
		this.f=f;
		g = new Grid(14,13,f);
		setWords(); //Liste des mots à trouver

	}


	/*
	 * Entrée des coordonnées de la case du premier mot et du dernier
	 */
	public String submit() {
		
		/*
		 * On créée un tableau Tanswer dans lequel on stockera le mot complet
		 *  suivant les coordonnées beg et end
		 */
		char[] Tanswer=new char[0];
		int j=0;
		
		if(beg[0]==end[0]) { //Si ils sont sur la même ligne
			if(beg[1]<end[1]) { //Si end est après beg
				Tanswer = new char[end[1]-beg[1]+1];
				for(int i=beg[1];i<=end[1];i++) {
					Tanswer[j]=g.getLetterAtIndex(i, beg[0]);
					j++;
				}
			}
			else { //Si beg est après end
				Tanswer = new char[beg[1]-end[1]+1];
				for(int i=end[1];i<=beg[1];i++) {
					Tanswer[j]=g.getLetterAtIndex(i, beg[0]);
					j++;
				}
			}
		}
		else { //Si ils sont sur la même colonne
			if(beg[0]<end[0]) { //Si end est après beg
				Tanswer = new char[end[0]-beg[0]+1];
				for(int i=beg[0];i<=end[0];i++) {
					Tanswer[j]=g.getLetterAtIndex(beg[1],i);
					j++;
				}
			}
			else { //Si beg est après end
				Tanswer = new char[beg[0]-end[0]+1];
				for(int i=end[0];i<=beg[0];i++) {
					Tanswer[j]=g.getLetterAtIndex(end[1],i);
					j++;
				}
			}
			
		}
		//On stocke le contenu du tableau dans answer
		answer=String.valueOf(Tanswer); 
		return verif();
	}

	
	/*
	 * Vérifications
	 */
	public String verif() {
		int j;
		for(int i=0;i<words.length;i++) {
			if(answer.equals(words[i]) || reverse(answer).equals(words[i])) {
				score.GoodAnswer(1000);
				for(j=i+1; j<words.length-1;j++) {
					words[i]=words[j];
				}
				return answer;
			}
			
		}
		score.BadAnswer();
		return "";
	}


	/*
	 * Retourne la chaine de caractère à l'envers
	 */
	public String reverse(String s) {
		String r = "";
		for(int i=s.length()-1;i>=0;i--) {
			r=r+s.charAt(i);
		}
		return r;
	}
	
	/*
	 * Initialise les mots à trouver
	 */
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


	public int[] getBeg() {
		return beg;
	}


	public void setBeg(int x, int y) {
		this.beg[0]=x;
		this.beg[1]=y;
	}


	public int[] getEnd() {
		return end;
	}


	public void setEnd(int x, int y) {
		this.end[0]=x;
		this.end[1]=y;
	}


	public String getAnswer() {
		return answer;
	}

	
	public int getScore() {
		return score.getScore();
	}
}
