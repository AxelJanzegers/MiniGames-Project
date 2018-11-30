package display;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//import java.util.Random;

public class Grid {

	char[][] tab;
	File file;
	File test = new File("GrilleSudoku/grille09x09_00.dat");
	int x,y;
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

		this.x = x;
		this.y = y;
		tab = new char[this.x-1][this.y];
		try {
			FileInputStream fis= new FileInputStream(f);
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			String tmp;
			tmp = br.readLine();	
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
	
	/*
	 * Renvoie un indice pour une lettre donnée
	 */
	public int letterToInt(char c) {
		int i=0;
		while(i<alphabet.length) {
			if(alphabet[i]==c) return i+1;
		}
		
		return 0;
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
