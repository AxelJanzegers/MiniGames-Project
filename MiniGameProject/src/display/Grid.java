package display;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.util.Random;

public class Grid {


	char[][] tab;
	File file;
	File test = new File("GrilleSudoku/grille09x09_00.dat");
	int x,y;
	
	
	public Grid(int x, int y) {
		this.x=x;
		this.y=y;
		tab = new char[this.x][this.y];
		
	}
	
	
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
						System.out.println(tab[i-1]);

					}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		} 

	}

	public char[][] getTab() {
		return tab;
	}

	public void setTab(char[][] tab) {
		this.tab = tab;
	} 

}
