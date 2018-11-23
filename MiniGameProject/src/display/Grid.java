package display;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

//import java.util.Random;

public class Grid {


	static File grilleSudoku = new File("GrilleSudoku/grille09x09_00.dat");
	char[][] g;
	
	public Grid (int n, int m) {
		g = new char[n][m];
	}
	
	
	
}
