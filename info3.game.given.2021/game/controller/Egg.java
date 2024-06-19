package controller;

import java.util.LinkedList;
import java.util.Random;

import Automates.IAction;
import Labyrinthe.Entity;
import Labyrinthe.Field;
import Labyrinthe.Sable;
import toolkit.Pair;

public class Egg implements IAction {

	private Field terrain;
	private Random rand;
	
	public Egg(Field f) {
		terrain = f;
	}
	
	public Egg(Field f, Random r) {
		terrain = f;
		rand = r;
	}
	
	@Override
	public void exec(Entity e) {
		LinkedList<Pair<Integer,Integer>> cases_possibles;
		if (e instanceof Sable) {
			cases_possibles = new LinkedList<Pair<Integer,Integer>>();
			for (int i = -1; i > -9; i--) {
				int[] cell = terrain.next_to(e,i);
				if (cell[0] < 0 || cell[1] < 0 || cell[0] > terrain.get_colonne() || cell[1] > terrain.get_ligne())
					continue;
				if (! terrain.isHerePossible(cell[0],cell[1],e))
					continue;
				cases_possibles.add(new Pair<Integer,Integer>(cell[0],cell[1]));
			}
		} else {
			cases_possibles = terrain.getClassList(e.layer());
		}
		Pair<Integer,Integer> p = cases_possibles.get(rand.nextInt(cases_possibles.size()));
		int x = p.x();
		int y = p.y();
		terrain.add(e.egg(x, y), x, y);
	}

}
