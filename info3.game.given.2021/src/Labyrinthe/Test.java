package Labyrinthe;

import java.io.IOException;
import java.io.PrintStream;

public class Test {
	public static void main(String args[]) throws IOException {
		System.out.println("Hello!");
		Field f = new Field(20, 20, 100, 30, 6, 6, 6, 6, 6, 15);
		//Field f = new Field(10, 10, 50);
		f.printGame();
		//f.printLabyrinthe_tmp();
	}
}
