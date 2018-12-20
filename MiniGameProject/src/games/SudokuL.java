package games;

import java.io.File;

public class SudokuL extends Sudoku {

	public SudokuL(String s) {
		super(s);
	}

	@Override
	public void selectGrid() {

		int str = 0;

		do {

			str = sc.nextInt();

			switch(str) {
			case 1 :
				sudokuGrid = new File("GrilleSudoku/grilleL_facile.dat");
				break;
			case 2 : 
				sudokuGrid = new File("GrilleSudoku/grilleL_moyen.dat");
				break;
			case 3 :
				sudokuGrid = new File("GrilleSudoku/grilleL_difficile.dat");
				break;
			case 4 :
				sudokuGrid = new File("GrilleSudoku/grilleL_expert.dat");
				break;
			default:
				System.out.println("Veuillez entre une valeur entre 1 et 4 :");
			}
		} while (str < 0 || str >= 4);
	}		
}

