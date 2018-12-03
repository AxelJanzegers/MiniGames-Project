package games;

import java.util.Arrays;
import java.util.Scanner;

import display.Library;

public class Hangman {
	
	private String word; //mot provenant de la biblioth�que
	private char[] Tword; //tableau o� est stock� word
	private char[] answer; //Tableau avec les lettres entr�es par l'utilisateur
	private int fails; //nombre d'erreurs
	private char l; //lettre entr�e par l'utilisateur
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
	 * Demande une lettre � l'utilisateur d'entrer une lettre puis 
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
		int presence = 0; //variable qui signalisera la pr�sence de la lettre entr�e, passe � 1 si la lettre est trouv�e, envoie le prog error si la var reste � 0
		int i=0;
		int alreadythere=0;
		while(i<Tword.length && alreadythere==0) {
			if (l == answer[i]) { 
				System.out.println("Cette lettre a d�j� �t� entr�e."); 
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
				System.out.println("Partie termin�e. Le mot �tait "+ word);
			}
	}
	
	public void startGame() {
		while (!(Arrays.equals(Tword, answer)) && fails<10 && l!='0') {
			System.out.println(answer);
			System.out.println(word);
			System.out.println("Erreurs restantes : "+(10-fails));
			enterLetter();
			if(Arrays.equals(Tword, answer)) System.out.println("F�licitations ! Le mot �tait en effet : "+ word);
		}
		sc.close();
	}
}

