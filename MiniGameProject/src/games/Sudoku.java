package games;
import java.util.Random;

public class Sudoku {

    Random r = new Random();
	protected int gSize = 9;	//Taille de la grille
	protected int rSize;    //Taille de la région
	protected int t[][];
	
	public Sudoku() {
		this.t = new int[gSize][gSize];
	}
	
	public void GenererGrille() {
	}

	public int VerifieUnicite() {
		return 0;
	}
	
	public void GridDisplay() {
	}
	
	public void SaisirUnCoup() {
		
	}
	
	public void JouerUnCoup() {
		
	}	
	
	public void AnnulerUnCoup() {
		
	}
}
