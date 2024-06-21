package draw;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.*;

import Labyrinthe.Joueur;
import controller.TicTac;
import listener.JSONWindow;

public class DrawInventaire extends JPanel {

	private static final long serialVersionUID = 1L;
	TicTac t;
	private ImageJPanel invent1, invent2;
	private PVJPanel pdv1, pdv2;
	private JLabel timer;

	private Sprite INVENTAIRE;
	private BufferedImage img_inventaire;
	
	private static final int temps = JSONWindow.time; // en secondes
	private int temps_actuel, cpt;
	Joueur j1, j2;
	
	public DrawInventaire(Joueur j1, Joueur j2) throws IOException {
		
		this.j1 = j1;
		this.j2 = j2;

		// TODO - lui donner l'inventaire de chaque joueur pour avoir l'objet courant

		this.Image();

		this.setPreferredSize(new Dimension(65, 65));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		// inventaire 1
		this.invent1 = new ImageJPanel();
		this.add(invent1);

		// points de vie 1
		this.pdv1 = new PVJPanel(JSONWindow.name1, j1);
		this.add(pdv1);

		// timer
		int min_act = temps / 60 ;
		int sec_act = temps % 60 ;
		if (min_act < 10) {
			if (sec_act < 10)
				this.timer = new JLabel("0" + min_act + " : 0" + sec_act);
			else
				this.timer = new JLabel("0" + min_act + " : " + sec_act);
		} else {
			if (sec_act < 10)
				this.timer = new JLabel(min_act + " : 0" + sec_act);
			else
				this.timer = new JLabel(min_act + " : " + sec_act);
		}
		timer.setPreferredSize(new Dimension(100, 65));
		timer.setHorizontalAlignment(SwingConstants.CENTER);
		timer.setVerticalAlignment(SwingConstants.CENTER);
		this.add(timer);

		// points de vie 2
		this.pdv2 = new PVJPanel(JSONWindow.name2, j2);
		this.add(pdv2);

		// inventaire 2
		this.invent2 = new ImageJPanel();
		this.add(invent2);

		this.temps_actuel = temps;
		this.cpt = 0;
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.gestionTime();
		if (cpt == 10)
			this.paintTimer();

		// TODO - donner objet courant à la place de DrawTerrain...
		invent1.setImage(img_inventaire, DrawTerrain.drawPickable(j1.picked()), 0, 0, 65);
		invent2.setImage(img_inventaire, DrawTerrain.drawPickable(j2.picked()), 0, 0, 65);
	}

	public void settimer(TicTac t) {
		this.t = t;
	}

	public void paintTimer() {
		temps_actuel -= 1;
		int min = temps_actuel / 60;
		int sec = temps_actuel % 60;
		if (min < 10) {
			if (sec < 10)
				timer.setText("0" + min + " : 0" + sec);
			else
				timer.setText("0" + min + " : " + sec);
		} else {
			if (sec < 10)
				timer.setText(min + " : 0" + sec);
			else
				timer.setText(min + " : " + sec);
		}
	}

	public void Image() throws IOException {
		this.INVENTAIRE = new Sprite("resources/graphisme/Structures/final_room.png", 24, 24);
		this.img_inventaire = INVENTAIRE.getSprite(2, 0);
	}

	public void gestionTime() {
		cpt++;
		if (cpt == 11)
			cpt = 0;
	}

}