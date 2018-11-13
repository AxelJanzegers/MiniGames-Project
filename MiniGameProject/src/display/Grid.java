package display;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

//import java.util.Random;

public class Grid {


	static File grilleSudoku = new File("GrilleSudoku/grille09x09_00.dat");
	String[] tableau = new String[0];
	
	public void afficheGrille() {
		try { 
			InputStream ips=new FileInputStream(grilleSudoku); 
			InputStreamReader ipsr=new InputStreamReader(ips); 
			BufferedReader br = new BufferedReader(ipsr); 
			String ligne;
			
			while ((ligne=br.readLine())!=null){ 
				String[] oldTableau = tableau; 
				int noligne = oldTableau.length; 
				tableau = new String[noligne+1];
				System.arraycopy(oldTableau, 0, tableau,0, noligne); 
				tableau[noligne] = ligne; 

				System.out.println(tableau[noligne]); 
			} 
			
			br.close(); 
			
		} catch (Exception e) { 
			System.out.println(e.toString()); 
		} 
	} 
}
