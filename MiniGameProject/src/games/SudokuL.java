package games;

import java.io.File;
import java.util.Scanner;

import display.Grid;

public class SudokuL extends Sudoku {

	public SudokuL() {
		super();
	}

	@Override
	public void selectGrid() {

		int str = 0;

		do {

			str = sc.nextInt();

			switch(str) {
			case 1 :
				grilleSudoku = new File("GrilleSudoku/grilleL_facile.dat");
				break;
			case 2 : 
				grilleSudoku = new File("GrilleSudoku/grilleL_moyen.dat");
				break;
			case 3 :
				grilleSudoku = new File("GrilleSudoku/grilleL_difficile.dat");
				break;
			case 4 :
				grilleSudoku = new File("GrilleSudoku/grilleL_expert.dat");
				break;
			default:
				System.out.println("Veuillez entre une valeur entre 1 et 4 :");
			}
		} while (str < 0 || str >= 4);
	}		
}

