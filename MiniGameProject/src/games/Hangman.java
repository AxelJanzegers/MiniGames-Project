package games;

import java.util.Arrays;
import java.util.Scanner;

import display.Library;

public class Hangman {
	
	String word;
	char[] Tword;
	char[] answer; //Tableau avec les lettres entrées par l'utilisateur
	int fails; //nombre d'erreurs
	char l;
	Scanner sc = new Scanner(System.in);
	int score = 45;
	
	
	public Hangman() {
		this.word = Library.GiveWord();		
		Tword = new char[this.word.length()];
		answer = new char[this.word.length()];
		
		word.getChars(0, word.length(), Tword, 0);
		for(int i=0; i<word.length();i++) answer[i] = '-';
		fails = 0;
	}
	
	public void enterLetter() {
		System.out.println("Entrez une lettre : (Entrez 0 pour quitter)");
		
		l=sc.nextLine().toUpperCase().charAt(0);
		verif(l);
	}
	
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
				}
			}
			i++;
		}
		if(presence==0) error();
	}
	
	public void error() {
		if(fails==0 && (Arrays.equals(Tword,answer))) {
			System.out.println(" Bravo vous avez le meilleur score , vous avez 100/100 !");
		}
		else {
		fails++;
		score = score -5;
		if(fails==10) {
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
		while (!(Tword.equals(answer)) && fails<10 && l!='0') {
			System.out.println(answer);
			System.out.println("Erreurs restantes : "+(10-fails));
			enterLetter();
			if(Tword.equals(answer)) System.out.println("Félicitations !");
		}
		sc.close();
	}
}

