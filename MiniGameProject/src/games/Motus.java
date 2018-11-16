package games;

import java.util.Scanner;

import display.Library;


public class Motus {
	
	private String word;
	private char[] Tword;  //Tableau qui détient le mot recherché , n'est jamais affiché
	private char[] answer; //Tableau vide au départ affichant petit a petit la réponse
	private char[] Twordsc;
	private int tries; //nombre d'essais
	private String wordsc;
	public Scanner sc = new Scanner(System.in);

	public Motus() {
		this.word = Library.GiveWord();		
		Tword = new char[this.word.length()];
		answer = new char[this.word.length()];
		Twordsc = new char[this.word.length()];
		
		word.getChars(0, word.length(), Tword, 0);
		for(int i=0; i<word.length();i++) answer[i] = '-';
		tries = 0;
	}
	
	public void enterWord() {
		System.out.println("Entrez votre réponse ");
		wordsc = sc.nextLine().toUpperCase();
		wordsc.getChars(0, wordsc.length(), Twordsc, 0);
		verif();
	}
	
	public void verif() {
		int presence = 0;
		int i=0;
		if(answer.length==wordsc.length()) {
			while(i<Tword.length) {
				if(answer[i] == Twordsc[i]) {
					System.out.println("Bip1");
				}
				else {
					if(Tword[i] == Twordsc[i]) {
						answer[i]=Tword[i];
				}}
				i++;
			}
			if(presence!=0) System.out.println("Une lettre est au mauvais endroit");
			MaxTries();
		}
		else { 
			System.out.println("Mauvais nombre de lettres");
			MaxTries();
		}
	}
	
	public void displayWord() {
		System.out.println(Tword);
	}
	
	public void MaxTries() {
		tries++;
		if(tries==6) {
			System.out.println("Partie terminée. Le mot était "+ word);
		}
	}
	
	public void startGame() {
		while (!(Tword.equals(answer)) && tries<6) {
			System.out.println(answer);
			System.out.println("Essais restants : "+(6-tries));
			enterWord();
			if(Tword.equals(Twordsc)) System.out.println("Pas mal pour un amateur !");
		}
		sc.close();
	}
	
}
