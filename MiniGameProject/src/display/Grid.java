package display;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Grid {

	static File grilleSudoku;
	char[][] tab;
	char[] tabAuto;
	int x,y;
	Scanner sc = new Scanner(System.in);
	
	public Grid(int x, int y) {

		this.x = x;
		this.y = y;
		tab = new char[this.x-1][this.y];
		tabAuto = new char[9];
		int str = 0;
		
		System.out.println("Choisissez votre jeu : \n1) Sudoku \n2) Wordoku");
		str = sc.nextInt();
		sc.nextLine();
		System.out.println("Choisissez votre difficulte : \n1) Facile \n2) Moyen \n3) Difficile \n4) Expert");
		if(str == 1) {
		do {

			str = sc.nextInt();

			switch(str) {
			case 1 :
				grilleSudoku = new File("GrilleSudoku/grille_facile.dat");
				break;
			case 2 : 
				grilleSudoku = new File("GrilleSudoku/grille_moyen.dat");
				break;
			case 3 :
				grilleSudoku = new File("GrilleSudoku/grille_difficile.dat");
				break;
			case 4 :
				grilleSudoku = new File("GrilleSudoku/grille_expert.dat");
				break;
			default:
				System.out.println("Veuillez entre une valeur entre 1 et 4");
			}
		} while (str < 0 || str >= 4);
		}
		else {
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
		
		if(str > 0 && str <= 4) {
			try {
				FileInputStream fis= new FileInputStream(grilleSudoku);
				InputStreamReader isr=new InputStreamReader(fis);
				BufferedReader br=new BufferedReader(isr);
				String tmp;
				tmp = br.readLine();	
				tabAuto = tmp.toCharArray();
				for(int i=1 ; i < this.x ; i++) {
					tmp = br.readLine();	
					tab[i-1] = tmp.toCharArray();
				}
				System.out.println("\n");
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}

	public char[] getTabAuto() {
		return tabAuto;
	}

	public void setTabAuto(char[] tabAuto) {
		this.tabAuto = tabAuto;
	}

	public char[][] getTab() {
		return tab;
	}

	public void setTab(char[][] tab) {
		this.tab = tab;
	} 

}
