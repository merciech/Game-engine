package controller;

import Automates.IAction;
import Labyrinthe.Bombe;
import Labyrinthe.Entity;
import Labyrinthe.Field;
import Labyrinthe.Fleche;
import Labyrinthe.Sable;

public class Rest implements IAction {

	private Field terrain;
	private int vie = 0;
	private TickListener tl;

	public Rest(Field f, int vie) {
		terrain = f;
		this.vie = vie;
	}

	public Rest(Field f, int vie, TickListener tl) {
		terrain = f;
		this.vie = vie;
		this.tl = tl;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	@Override
	public void exec(Entity e) {
		if ((e instanceof Sable || e instanceof Bombe || e instanceof Fleche) && vie == 1) {
			e.power(-1);
			return;
		}
		e.power(vie);

	}

	@Override
	public String toString() {
		String s = "Power";
		return s;
	}

}
