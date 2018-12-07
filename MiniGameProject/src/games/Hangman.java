package games;

import java.util.Arrays;
import java.util.Scanner;

import display.Library;

public class Hangman {
	

	int score = 45;
	private String word; //mot provenant de la bibliothèque
	private char[] Tword; //tableau où est stocké word
	private char[] answer; //Tableau avec les lettres entrées par l'utilisateur
	private int fails; //nombre d'erreurs
	private char l; //lettre entrée par l'utilisateur
	public Scanner sc = new Scanner(System.in);
	
	
	public Hangman() {
		this.word = Library.GiveWordofXLetters(7);		
		Tword = new char[this.word.length()];
		answer = new char[this.word.length()];
		
		word.getChars(0, word.length(), Tword, 0);
		answer[0]=Tword[0];
		for(int i=1; i<word.length();i++) answer[i] = '-';
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
		int i=1;
		
		while(i<Tword.length) {
			
			
				if (l == Tword[i]) {
				answer[i]=Tword[i];
				presence=1;
				
			}
			i++;
		}
		if(presence==0) error();
	}
	
	
	

	public void setWord(String word) {
		this.word = word;
	}

	public void error() {
		if(fails==0 && (Arrays.equals(Tword,answer))) {
			System.out.println(" Bravo vous avez le meilleur score , vous avez 100/100 !");
		}
		else {
		fails++;
		score = score -5;
		if(fails==8) {
			System.out.println("Partie terminée. Le mot était "+ word);
			System.out.println("Score : 0 ");
		}
		}
	}
	
	public void startGame() {
		System.out.println("Mot trouvé sans erreurs : 100 pts \n"
				+ "Mot trouvé avec 1 erreur : 45 pts \n"
				+ "Mot trouvé avec 2 erreurs : 40 pts \n"
				+ "Mot trouvé avec 3 erreurs : 35 pts \n"
				+ "Mot trouvé avec 4 erreurs : 30 pts \n"
				+ "Mot trouvé avec 5 erreurs : 25 pts \n"
				+ "Mot trouvé avec 6 erreurs : 20 pts \n"
				+ "Mot trouvé avec 7 erreurs : 15 pts \n"
				+ "Mot trouvé avec 8 erreurs : 10 pts \n"
				+ "Mot trouvé avec 9 erreurs : 5 pts \n");
		
		while (!(Arrays.equals(Tword, answer)) && fails<10 && l!='0') {
			System.out.println(answer);
			System.out.println(word);
			System.out.println("Erreurs restantes : "+(10-fails));
			enterLetter();
			if(Arrays.equals(Tword, answer)) System.out.println("Félicitations ! Le mot était en effet : "+ word);
		}
		sc.close();
	}

	public String getWord() {
		// TODO Auto-generated method stub
		return word;
	}
	
	public String getAnswer() {
		String Sanswer = new String(answer);
		return Sanswer;
	}

	public int getFails() {
		return fails;
	}
}

