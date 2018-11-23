package games;

import java.util.Arrays;
import java.util.Scanner;

import display.Library;


public class Motus {
	
	String word;
	char[] Tword;  //Tableau qui détient le mot recherché , n'est jamais affiché
	char[] answer; //Tableau vide au départ affichant petit a petit la réponse
	char[] Twordsc;
	int tries; //nombre d'essais
	String wordsc;
	Scanner sc = new Scanner(System.in);
	int score = 40;

	public Motus() {
		this.word = Library.GiveWordofXLetters(6);		
		Tword = new char[this.word.length()];
		answer = new char[this.word.length()];	
		word.getChars(0, word.length(), Tword, 0);
		for(int i=0; i<word.length();i++) answer[i] = '-';
		tries = 0;
	}
	
	public void enterWord() {
		System.out.println("Entrez votre réponse ");
		wordsc = sc.nextLine().toUpperCase();
		if(wordsc.length() == 0) {
			System.out.println("Rentre quelque chose stp c'est génant");
			MaxTriesNormal();
		} else {
		Twordsc = new char[this.wordsc.length()];
		wordsc.getChars(1, wordsc.length(), Twordsc, 1);
		verif();
		}
	}
	
	public void verif() {
		int i=0;
		int j=0;
		if(answer.length == Twordsc.length) {
			while(i<Tword.length) {
					if(Tword[i] == Twordsc[i]) {
						answer[i]=Tword[i];
				}
					else for(j=0;j<Tword.length;j++)
						if(Twordsc[i] == Tword[j]) {
							System.out.println("la lettre "+Twordsc[i]+ " a la postion " + (i+1) + " n'est pas a la bonne place ");
						}
					
				i++;
			}
			MaxTriesNormal();
		}
		else {
			System.out.println("Mauvais nombre de lettres");
			MaxTriesNormal();
		}
	}
	
	public void displayWord() {
		System.out.println(Tword);
	}
	
	public void MaxTriesFacile() {
		if(tries==0 && (Arrays.equals(Tword,answer))) {
			System.out.println(" Bravo vous avez le meilleur score , vous avez 100/100 !");
		}
		else {
		tries++;
		score = score -5;
			if(tries==4 && !(Arrays.equals(Tword,answer))) {
			System.out.println("Partie terminée. Le mot était "+ word);
			System.out.println("Score : 0 ");
			}
		}
	}
	
	public void MaxTriesNormal() {
		if(tries==0 && (Arrays.equals(Tword,answer))) {
			System.out.println(" Bravo vous avez le meilleur score , vous avez 100/100 !");
		}
		else {
		tries++;
		score = score -5;
			if(tries==6 && !(Arrays.equals(Tword,answer))) {
			System.out.println("Partie terminée. Le mot était "+ word);
			System.out.println("Score : 0 ");
			}
		}
	}
	
	public void MaxTriesDifficile() {
		if(tries==0 && (Arrays.equals(Tword,answer))) {
			System.out.println(" Bravo vous avez le meilleur score , vous avez 100/100 !");
		}
		else {
		tries++;
		score = score -5;
			if(tries==8 && !(Arrays.equals(Tword,answer))) {
			System.out.println("Partie terminée. Le mot était "+ word);
			System.out.println("Score : 0");
			}
		}
	}
	
	public void startGame() {
		System.out.println("Mot trouvé sans erreurs : 100 pts \n"
				+ "Mot trouvé avec 1 erreur : 40 pts \n"
				+ "Mot trouvé avec 2 erreurs : 35 pts \n"
				+ "Mot trouvé avec 3 erreurs : 30 pts \n"
				+ "Mot trouvé avec 4 erreurs : 25 pts \n"
				+ "Mot trouvé avec 5 erreurs : 15 pts \n");
		while (!(Arrays.equals(Tword, answer)) && tries<6) {
			answer[0]=Tword[0];
			System.out.println(answer);
			System.out.println("Essais restants : "+(6-tries));
			enterWord();
		}
			if(Arrays.equals(Tword,answer)) {
				System.out.println(" Le mot etait " +word);
				System.out.println("Score : "+score);
				System.out.println("Pas mal pour un amateur !");
			}
		sc.close();
	}
	
}
