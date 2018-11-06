package games;

import display.Library;

public class Hangman {
	
	String word;
	
	
	
	public Hangman() {
		this.word = Library.GiveWord();
		
	}
	
	
	
	
	
	
	public void startGame() {
		System.out.println(word);
	}
	
	
	
	
	
	
}
