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
		this.t[][] = { 
				{1,2,3,4,5,6,7,8,9},
				{2,3,4,5,6,7,8,9,1},
				{3,4,5,6,7,8,9,1,2},
				{4,5,6,7,8,9,1,2,3},
				{5,6,7,8,9,1,2,3,4},
				{6,7,8,9,1,2,3,4,5},
				{7,8,9,1,2,3,4,5,6},
				{8,9,1,2,3,4,5,6,7},
				{9,1,2,3,4,5,6,7,8}
		};
	}

	public int VerifieUnicite() {
		return 0;
	}
	
	public void GridDisplay() {
		for (int i = 0 ; i < this.gSize ; i++ ) {
			for (int j = 0 ; j < gSize ; j++) {
				System.out.print(this.t[i][j] + "  ");
				if(j == 2 || j == 5) {
					System.out.print(" | ");
				}
			}
			System.out.println();
			if(i == 2 || i == 5 ) {
				System.out.println("--------------------------------");
			}
		}
	}
	
	public void SaisirUnCoup() {
		
	}
	
	public void JouerUnCoup() {
		
	}	
	
	public void AnnulerUnCoup() {
		
	}
}
