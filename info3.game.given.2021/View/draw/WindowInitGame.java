package draw;

import javax.swing.*;

import Automates.Automate;
import Automates.AutomatonLoader;
import Labyrinthe.Field;
import Labyrinthe.Joueur;
import controller.KeyPressed;
import controller.TicTac;
import controller.TickListener;
import listener.JSONWindow;
import listener.Key_Listener;

import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;

/*
 * première fenêtre du jeu pour remplir le fichier de config
 */
public class WindowInitGame extends JFrame {

	public static int T_case = 30;

	private static final long serialVersionUID = 1L;

	JTextField name1, name2;
	JRadioButton labyrinthe, arene;
	JSlider s_HAUTEUR, s_LARGEUR, s_VISIBILITY;

	public WindowInitGame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Bienvenue dans ce moteur de Jeux");
		this.setSize(450, 400);
		
		JPanel choice = new JPanel();
		choice.setBackground(Color.BLACK);
		JLabel jeu = new JLabel("Sélection du jeu : ");
		labyrinthe = new JRadioButton("Labyrinthe");
		arene = new JRadioButton("Arène");
		ButtonGroup group = new ButtonGroup();
		group.add(labyrinthe);
		group.add(arene);
		
		choice.add(jeu);
		choice.add(labyrinthe);
		choice.add(arene);
		
		JButton jouer = new JButton("Jouer");
		jouer.addActionListener(new JSONWindow(this));
		choice.add(jouer);
		
		this.add(choice, BorderLayout.CENTER);
		
		this.setVisible(true);
	}

	public void initGame() throws IOException {

		// initialisation de la grille
		Field terrain = new Field(JSONWindow.hauteur, JSONWindow.largeur, JSONWindow.densite, 30, 26, 1, 1, 1, 1, 25, 25, 50, 10);
		
		KeyPressed kp = new KeyPressed();

		// ajout d'un joueur pour tester
		Joueur j1 = new Joueur(2, 0, 1);
		Joueur j2 = new Joueur(3, 0, 2);
		terrain.add(j1, 2, 0);
		terrain.add(j2, 3, 0);
		terrain.printGame();
		
		//ajout d'un automate
		AutomatonLoader al = new AutomatonLoader(terrain, kp);
		LinkedList<Automate> l_aut = al.loadAutomata("resources/automata/test_cond.gal");

		//Initialisation de la fenêtre
		DrawWindow w = new DrawWindow(terrain.get_colonne(), terrain.get_ligne(), terrain, T_case, JSONWindow.visibility, j1, j2);
		
		Viewport v1 = new Viewport(w.get_dt1(), T_case, JSONWindow.visibility);
		Viewport v2 = new Viewport(w.get_dt2(), T_case, JSONWindow.visibility);
		
		TickListener tl = new TickListener(terrain);
		TicTac tt = new TicTac(tl, j1, j2, v1, v2);
		tt.add_window(w);
		
		w.init_Window(v1, v2, w.get_invent(),tt);
		v1.centrerViewport(j1);
		v2.centrerViewport(j2);
		
		//Création du lien entre Entity et Automate
		tl.add(l_aut.getLast(), j1);

		// ajout d'un Keylistener
		Key_Listener k = new Key_Listener(terrain, kp);
		w.addKeyListener(k);

	}

	public String getname(int num_joueur) throws IOException {
		if (num_joueur == 1)
			return name1.getText();
		else if (num_joueur == 2)
			return name2.getText();
		else
			throw new IOException("pas de nom");
	}

	public String getjeu() throws IOException {
		if (labyrinthe.isSelected())
			return "labyrinthe";
		else if (arene.isSelected())
			return "arene";
		else
			return null ;
	}

	public int getSlider(String champs) {
		if (champs == "HAUTEUR")
			return s_HAUTEUR.getValue();
		else if (champs == "LARGEUR")
			return s_LARGEUR.getValue();
		else if (champs == "VISIBILITY")
			return s_VISIBILITY.getValue();
		else
			return -1;
	}

}
