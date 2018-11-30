package games;

import java.util.Arrays;
import java.util.Scanner;

import display.*;

public class Sudoku {
	
	Grid grille;
	Scanner sc = new Scanner(System.in);
	
	public Sudoku() {
		this.grille = new Grid(10,9);
	}
	
	public boolean grilleRemplie() {
		for(int i = 0; i < grille.getTab().length ; i++) {
			for(int j = 0 ; j < grille.getTab().length ; j++) {
				if(Character.compare(this.grille.getTab()[i][j],'0') == 0) {
					return false;
				}
			}
		}
		System.out.println("la grille est remplie");
		return true;
	}

	public void afficherGrille() {
		for(int i = 0; i < grille.getTab().length ; i++) {
			System.out.println("+---++---++---++---++---++---++---++---++---+");
			for(int j = 0 ; j < grille.getTab().length ; j++) {
				System.out.print("| " + this.grille.getTab()[i][j] + " |");
			}
			System.out.println();
		}
		System.out.println("+---++---++---++---++---++---++---++---++---+");
		System.out.println();
		System.out.println(Arrays.deepToString(this.grille.getTab()));
		System.out.println();
	}
	
	public boolean estAutorise(char c) {
		for(char tmp : this.grille.getTabAuto()) {
			if(Character.compare(tmp, c) == 0) {
				return true;
			}
		}
		System.out.println("Valeur incorrecte");
		return false;
	}
	
	public void jouerUnCoup() {
		int l = 0;
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
		val = sc.nextLine().charAt(0);
		
			if(estAutorise(val)) {
				char tmp = grille.getTab()[l][c];
				grille.getTab()[l][c] = val;
				if((l < 0 && l >= 9) || (c < 0 && c >= 9) || Character.compare(tmp,'0') != 0 && !verifieRegion()) {
					System.out.println("Coup incorrect");
					grille.getTab()[l][c] = tmp;
				}
			}
			afficherGrille();
		}
		sc.close();
	}

	public boolean verifieLigne() {
		int cpt = 0;
		for(char tmp : this.grille.getTabAuto()) {
			for(int i = 0 ; i < grille.getTab().length ; i++) {
				cpt = 0;
				for(int j = 0; j < grille.getTab().length ; j++) {
					if(Character.compare(tmp, this.grille.getTab()[i][j]) == 0 && cpt < 2) {
						cpt++;
					}
					else if(cpt == 2) {
						System.out.println("Valeur deja presente sur la ligne");
						return false;
					}
				}
			}
		}
		return true;
	}

	public boolean verifieColonne() {
		int cpt = 0;
		for(char tmp : this.grille.getTabAuto()) {
			for(int i = 0 ; i < grille.getTab().length ; i++) {
				cpt = 0;
				for(int j = 0; j < grille.getTab().length ; j++) {
					if(Character.compare(tmp, this.grille.getTab()[j][i]) == 0 && cpt < 2) {
						cpt++;
					}
					else if(cpt == 2) {
						System.out.println("Valeur deja presente sur la colonne");
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public boolean verifieRegion() {
		char[] tab2 = new char[this.grille.getTab().length];
		int pos = 0;
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				tab2[pos] = this.grille.getTab()[i][j];
				pos++;
			}
		}
		int cpt = 0;
		for(char tmp : this.grille.getTabAuto()) {
			for(int k = 0 ; k < tab2.length ; k++) {
				if(Character.compare(tmp, tab2[k]) == 0 && cpt < 2) {
					cpt++;
				}
				else if(cpt == 2) {
					System.out.println("Valeur deja presente dans la region");
					return false;
				}
			}
		}
		return true;
	}

	
	public boolean verifieUnicite() {
		if(verifieLigne() && verifieColonne() && verifieRegion()) {
			return true;
		}
		return false;
	}
}
