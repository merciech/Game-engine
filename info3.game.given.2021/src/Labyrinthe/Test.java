package Labyrinthe;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class Test {
	public static void main(String args[]) throws IOException {
		System.out.println("Hello!");
		Field f = new Field(20, 25, 100, 5, 1, 1, 1, 1, 1, 50, 25, 25, 10, 2, new Random(0));
		f.printGame();
		// f.printLabyrinthe_tmp();
	}
}
