package tests;

import java.io.IOException;
import draw.DrawWindow;
import draw.Viewport;
import listener.Key_Listener;
import Labyrinthe.Field;
import Labyrinthe.Joueur;

/*
 * Main de test pour la view
 */

public class Game {

	private final static int LARGEUR = 30;
	private final static int HAUTEUR = 30;
	private static final int T_case = 20;

	public static void main(String[] args) throws IOException {

		//initialisation de la grille
		Field terrain = new Field(HAUTEUR, LARGEUR, 10);
		
		// ajout d'un joueur pour tester
		Joueur j1 = new Joueur(20, 20, terrain);
		terrain.set_element(20, 20, j1, null);

		// initialisation de la fenêtre
		DrawWindow w = new DrawWindow(terrain.get_colonne(), terrain.get_ligne(), terrain, T_case);
		//Viewport v = new Viewport(w.get_dt(), T_case);
		w.init_Window();
		//v.centrerViewport(j1);
		
		// ajout d'un Keylistener
		Key_Listener k = new Key_Listener(j1, w.get_dt1());
		w.addKeyListener(k);

	}

}
