package games;

import java.util.Arrays;
import java.util.Scanner;

import display.Library;

public class Hangman {
	
	private String word; //mot provenant de la bibliothèque
	private char[] Tword; //tableau où est stocké word
	private char[] answer; //Tableau avec les lettres entrées par l'utilisateur
	private int fails; //nombre d'erreurs
	private char l; //lettre entrée par l'utilisateur
	public Scanner sc = new Scanner(System.in);
	Score score = new Score();
	
	
	public Hangman() {
		this.word = Library.GiveWord();		
		Tword = new char[this.word.length()];
		answer = new char[this.word.length()];
		
		word.getChars(0, word.length(), Tword, 0);
		for(int i=0; i<word.length();i++) answer[i] = '-';
		fails = 0;
	}
	
	/*
	 * Demande une lettre à l'utilisateur d'entrer une lettre puis 
	 * appelle la fonction verif
	 */
	public void enterLetter() {
		System.out.println("Entrez une lettre : (Entrez 0 pour quitter)");
		l=sc.nextLine().toUpperCase().charAt(0);
		
		verif(l);
	}
	
	
	/*
	 * Partie verifications
	 */
	public void verif(char l) {
		int presence = 0; //variable qui signalisera la présence de la lettre entrée, passe à 1 si la lettre est trouvée, envoie le prog error si la var reste à 0
		int i=0;
		int alreadythere=0;
		while(i<Tword.length && alreadythere==0) {
			if (l == answer[i]) { 
				System.out.println("Cette lettre a déjà été entrée."); 
				alreadythere++;
			}
			else { 
				if (l == Tword[i]) {
				answer[i]=Tword[i];
				presence=1;
				score.GoodAnswer(100);
				}
			}
			i++;
		}
		if(presence==0) {
			error();
			score.BadAnswer();
		}
		score.AfficheScore();
	}
	
	
	public void error() {
		fails++;
			if(fails==10) {
				System.out.println("Partie terminée. Le mot était "+ word);
			}
	}
	
	public void startGame() {
		while (!(Arrays.equals(Tword, answer)) && fails<10 && l!='0') {
			System.out.println(answer);
			System.out.println(word);
			System.out.println("Erreurs restantes : "+(10-fails));
			enterLetter();
			if(Arrays.equals(Tword, answer)) System.out.println("Félicitations ! Le mot était en effet : "+ word);
		}
		sc.close();
	}
}

