package Labyrinthe;

import toolkit.Categorie;

public class Arc extends Entity {

	boolean FlecheTrans;

	public Arc(int ligne, int colonne) {
		this.colonne = colonne;
		this.ligne = ligne;
		this.category = Categorie.P;
		this.team = 3;
		layer = 2;
		FlecheTrans = false;
	}

	@Override
	public Entity egg(int ligne, int colonne) {
		return new Arc(ligne,colonne);

	}

	@Override
	public void pop() {
		explode();
	}

	@Override
	public void wizz() {
		FlecheTrans = !FlecheTrans;
	}

	@Override
	public int hit() {
		if (FlecheTrans) {
			return -7;
		}
		return -1;
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub

	}
}
