package display;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


import java.util.Scanner;



public class Grid {


	char[][] tab;
	File file;
	char[] tabAuto;

	int x,y;

	Scanner sc = new Scanner(System.in);

	char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	
	/*
	 * Constructeur grille sans fichier (motus)
	 */
	public Grid(int x, int y) {
		this.x=x;
		this.y=y;
		tab = new char[this.x][this.y];
		
	}
	
	/*
	 * Constructeur grille avec fichier (sudoku, mots meles)
	 */
	public Grid(int x, int y, File f) { 

		tabAuto = new char[9];
		this.x = x;
		this.y = y;
		tab = new char[this.x-1][this.y];

		try {
			FileInputStream fis= new FileInputStream(f);
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			String tmp;
			tmp = br.readLine();	
			tabAuto = tmp.toCharArray();
			System.out.println();
				for(int i=1 ; i < this.x ; i++) {
					tmp = br.readLine();	
					tab[i-1] = tmp.toCharArray();
						//System.out.println(tab[i-1]);

					}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		} 

	}
		
	/*	int str = 0;
>>>>>>> axel
		
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
		}*/

	
	public char[] getTabAuto() {
		return tabAuto;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/*
	 * Renvoie un indice pour une lettre donn�e
	 */
	public int letterToInt(char c) {
		int i=0;
		while(i<alphabet.length) {
			if(alphabet[i]==c) return i+1;
		}
		
		return 0;
	}

	/*
	 * 
	 */
	public char getLetterAtIndex(int x, int y) {
		return tab[x][y];		
	}
	
	/*
	 * 
	 */
	public void setLetterAtIndex(int x, int y, char c) {
		this.tab[x][y]=c;
	}
	
	/*
	 * GETTER SETTER
	 */
	public char[][] getTab() {
		return tab;
	}

	public void setTab(char[][] tab) {
		this.tab = tab;
	} 
	
	/*
	 * Affichage de grille pour les mots meles
	 */
	public void displayGridWSP() {
		
		System.out.println("    1 2 3 4 5 6 7 8 9 10\n");
		for(int i=0;i<this.x-1;i++) {
			System.out.print(alphabet[i]+"   ");
			for(int j=0;j<this.y;j++) {
				System.out.print(tab[i][j]+" ");
			}
			System.out.println("");
		}
	}

}
