package display;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

//import java.util.Random;

public class Grid {


	char[][] g;
	File file;
	File test = new File("GrilleSudoku/grille09x09_00.dat");
	
	
	public Grid (int n) {
		g = new char[n][n];
		
	}
	
	public Grid(int n, int m) {
		g=new char[n][m];
	}
	
	public Grid (int n, File f) {
		g = new char[n][n];
		this.file=f;
		
	}
	
	
	public void createGrid() {
		
	}
	
	public void afficheGrille() {
		try { 
			InputStream ips=new FileInputStream(test); 
			InputStreamReader ipsr=new InputStreamReader(ips); 
			BufferedReader br = new BufferedReader(ipsr); 
			String ligne;
			
			
			
			
			br.close(); 
			
		} catch (Exception e) { 
			System.out.println(e.toString()); 
		} 
	} 
}
