package games;

import java.util.Arrays;
import java.util.Scanner;

import display.Library;
import display.Score;

public class Motus {
	

	String word;
	char[] Tword;  //Tableau qui détient le mot recherché , n'est jamais affiché
	char[] answer; //Tableau vide au départ affichant petit a petit la réponse
	char[] Twordsc;
	int[] Tdis; //Tableau qui servira à l'affichage(0:mauvaise réponse, 1:mal placée, 2:bien placée)
	int tries; //nombre d'essais
	String wordsc;
	Scanner sc = new Scanner(System.in);
	Score score = new Score();


	public Motus() {
		this.word = Library.GiveWordofXLetters(6);		
		Tword = new char[this.word.length()];
		answer = new char[this.word.length()];	
		Tdis = new int[this.word.length()];
		word.getChars(0, word.length(), Tword, 0);
		answer[0]=Tword[0];
		answer[3]=Tword[3];
		for(int i=1; i<3;i++) answer[i] = '.';
		for(int i=4; i<word.length();i++) answer[i] = '.';
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
		for(int i=0; i<Tdis.length;i++) {
			Tdis[i]=0;
		}
		int i=0;
		int j=0;
		int ilenfautun = 0;
		if(answer.length == Twordsc.length) {
			while(i<Tword.length) {
				
					if(Tword[i] == Twordsc[i]) {
						answer[i]=Tword[i];
						Tdis[i]=2;
						score.GoodAnswer(100, Tword.length-tries);
						ilenfautun++;
						
				}
					
					else for(j=0;j<Tword.length;j++)
						if(Twordsc[i] == Tword[j]) {
							System.out.println("la lettre "+Twordsc[i]+ " a la postion " + (i+1) + " n'est pas a la bonne place ");
							Tdis[i]=1;
							score.GoodAnswer(50, Tword.length-tries);
						}
				
				
				i++;
			}
			MaxTriesNormal();
			if (ilenfautun!=0) score.BadAnswer();
		}
		else {
			System.out.println("Mauvais nombre de lettres");
			MaxTriesNormal();
			score.BadAnswer();
		}
		if(Arrays.equals(Tword, answer)) {
			score.GoodAnswer(10000);
		}
		score.AfficheScore();
		
	}
	
	public void displayWord() {
		System.out.println(Tword);
	}
	
	public void MaxTriesFacile() {
		tries++;
			if(tries==4 && !(Arrays.equals(Tword,answer))) {
			System.out.println("Partie terminée. Le mot était "+ word);
			System.out.println("Score : 0 ");
			}
	}
	
	public void MaxTriesNormal() {
		tries++;
			if(tries==6 && !(Arrays.equals(Tword,answer))) {
			System.out.println("Partie terminée. Le mot était "+ word);
			System.out.println("Score : 0 ");
			}
	}
	
	public void MaxTriesDifficile() {
		tries++;
			if(tries==8 && !(Arrays.equals(Tword,answer))) {
			System.out.println("Partie terminée. Le mot était "+ word);
			}
	}
	
	public void startGame() {
		while (!(Arrays.equals(Tword, answer)) && tries<6) {
			answer[0]=Tword[0];
			System.out.println(answer);
			System.out.println("Essais restants : "+(6-tries));
			displayWord();
			enterWord();
		}
			if(Arrays.equals(Tword,answer)) {
				System.out.println(" Le mot etait " +word);
				System.out.println("Pas mal pour un amateur !");
			}
		sc.close();
	}
	
	public void setWordSC(char[] cx) {
		Twordsc=cx;
	}
	
	public char getLetterAtIndex(int i) {
		return answer[i];		
	}

	public int[] getTdis() {
		return Tdis;
	}
	
	public int getScore() {return score.getScore();}
	
	public String getWord() {
		return word;
	}

	public Boolean win() {
		if (Arrays.equals(Twordsc, answer)) return true;
		else return false;
	}
	
}
