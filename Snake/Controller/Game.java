/*
 * Main de test pour la view
 */

public class Game {
	
	/* TODO - HAUTEUR et LARGEUR seront les dimensions de la matrice */
	final static int LARGEUR = 600;
	final static int HAUTEUR = 600;

	public static void main(String[] args) {

		// initialisation de la fenêtre
		Window w = new Window(LARGEUR, HAUTEUR);
		TicTac t = new TicTac(w);

		w.init_Window(t);
	}

}
