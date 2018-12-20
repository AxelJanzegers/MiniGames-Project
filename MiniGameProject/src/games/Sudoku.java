package games;


import display.Grid;
import display.Score;

import java.io.File;

import java.util.Scanner;



public class Sudoku {
	
	protected Grid g;
	protected Scanner sc = new Scanner(System.in);
	protected char[] tab1D = new char[9];
	protected File sudokuGrid;
	protected Score score = new Score();
	protected int err;
	
	
	public Sudoku(String s) {
		sudokuGrid = new File(s);
		this.g = new Grid(10,9,sudokuGrid);
	}
	
	public Grid getGrille() {
		return g;
	}

	public void selectGrid() {
		int str = 0;

		System.out.println("Choisissez votre difficulte : \n1) Facile \n2) Moyen \n3) Difficile \n4) Expert");

		do {

			str = sc.nextInt();

			switch(str) {
			case 1 :
				sudokuGrid = new File("GrilleSudoku/grille_facile.dat");
				break;
			case 2 : 
				sudokuGrid = new File("GrilleSudoku/grille_moyen.dat");
				break;
			case 3 :
				sudokuGrid = new File("GrilleSudoku/grille_difficile.dat");
				break;
			case 4 :
				sudokuGrid = new File("GrilleSudoku/grille_expert.dat");
				break;
			default:
				System.out.println("Veuillez entre une valeur entre 1 et 4");
			}
		} while (str < 0 || str >= 4);
	}

	public Boolean fullGrid() {
		for(int i = 0; i < g.getTab().length ; i++) {
			for(int j = 0 ; j < g.getTab().length ; j++) {
				if(Character.compare(this.g.getTab()[i][j],'0') == 0) {
					return false;
				}
			}
		}
		System.out.println("la grille est remplie");
		return true;
	}

	
	
	public char makeAMove(char val, int l, int c) {
		/*int l = 0;
		int c = 0;
		char val = 0;
		while(!grilleRemplie()) {
		System.out.println("Entrez la ligne : ");
		l = sc.nextInt()-1;
		sc.nextLine();
		System.out.println("Entrez la colonne : ");
		c = sc.nextInt()-1;
		sc.nextLine();
		System.out.println("Entrez la valeur : ");
		val = sc.nextLine().charAt(0);*/
		
		System.out.println(val + " joué en "+l+","+c);
				char tmp = g.getTab()[l][c];
				g.setLetterAtIndex(l, c, val);
				if((l < 0 && l >= 9) || (c < 0 && c >= 9) || !verifAll()) {
					System.out.println("Coup incorrect");
					g.getTab()[l][c] = tmp;
				}
				return g.getTab()[l][c];
			
		}
		//sc.close();
	

	public boolean verifLine() {
		int cpt = 0;
		for(char tmp : this.g.getTabAuto()) {
			
			for(int i = 0 ; i < g.getTab().length ; i++) {
				cpt = 0;
				for(int j = 0; j < g.getTab().length ; j++) {
					if(Character.compare(tmp, this.g.getTab()[i][j]) == 0 && cpt < 2) {
						cpt++;
					}
					else if(cpt == 2) {
						System.out.println("Valeur deja presente sur la ligne");
						err=1;
						return false;
					}
				}
			}
		}
		return true;
	}

	public boolean verifColumn() {
		int cpt = 0;
		for(char tmp : this.g.getTabAuto()) {
			
			for(int i = 0 ; i < g.getTab().length ; i++) {
				cpt = 0;
				for(int j = 0; j < g.getTab().length ; j++) {
					if(Character.compare(tmp, this.g.getTab()[j][i]) == 0 && cpt < 2) {
						
						cpt++;
					}
					else if(cpt == 2) {
						System.out.println("Valeur deja presente sur la colonne");
						err=2;
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public char[] tab2DTo1D(int x, int y) {
		int pos = 0;
		for(int i = x; i < x+3 ; i++) {
			for(int j = y ; j < y+3 ; j++) {
				this.tab1D[pos] = this.g.getTab()[i][j];
				pos++;
			}
		}
		return tab1D;
	}

	public boolean verifRegion() {
		int cpt = 0;
		for(char tmp : this.g.getTabAuto()) {
			cpt = 0;
			for(int i = 0 ; i < 9 ; i = i+3) {
				for(int j = 0 ; j < 9 ; j = j+3) {
					cpt = 0;
					char[] tmp2 = tab2DTo1D(i, j);
					for(int k = 0; k < tmp2.length ; k++) {
						if(Character.compare(tmp, tmp2[k]) == 0 && cpt < 2) {
							
							cpt++;
						}
						else if(cpt >= 2) {
							System.out.println("Valeur deja presente dans la region");
							err=3;
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	public boolean verifAll() {
		if(verifLine() && verifColumn() && verifRegion()) {
			score.GoodAnswer(100);
			err=0;
			return true;
		}
		score.BadAnswer();
		return false;
	}
	
	public void deleteValue(int x, int y) {
		g.setLetterAtIndex(x, y, '0');
	}
	
	public int getScore() {
		return score.getScore();
	}
	
	public int getErr() {
		return err;
	}
}
