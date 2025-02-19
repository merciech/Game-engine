package controller;

import java.util.LinkedList;

import Automates.IAction;
import Labyrinthe.*;
import toolkit.Direction;

public class Hit implements IAction {

	private TickListener tl;
	public Field terrain;

	public Hit(Field terrain, TickListener tl) {
		this.terrain = terrain;
		this.tl = tl;
	}

	public Hit(Field terrain) {
		this.terrain = terrain;
		this.tl = null;
	}

	@Override
	public void exec(Entity e) {
		if (e instanceof Lave || e instanceof Sable) {
			int[] coo = terrain.next_to_outside(e, Direction.H);
			LinkedList<Entity> list = terrain.getElement(coo[0], coo[1]);
			int cpt = 0;
			Entity tohit = list.get(cpt);
			int taille = list.size();
			while (!(tohit instanceof Joueur) && !(tohit instanceof Zombie) && !(tohit instanceof Squelette)
					&& cpt < taille) {
				tohit = list.get(cpt);
				cpt++;
			}
			if (!(tohit instanceof Joueur) && !(tohit instanceof Zombie) && !(tohit instanceof Squelette))
				return;
			if (e instanceof Lave) {
				System.out.println("Lave hit");
				tohit.power(-5);
			}
			if (e instanceof Sable) {
				tohit.power(-2);
			}
		} else if (e instanceof Fleche) {
			int[] coo = terrain.next_to_outside(e, Direction.H);
			LinkedList<Entity> list = terrain.getElement(coo[0], coo[1]);
			int cpt = 0;
			Entity tohit = list.get(cpt);
			int taille = list.size();
			while (!(tohit instanceof Joueur) && !(tohit instanceof Zombie) && !(tohit instanceof Squelette)
					&& !(tohit instanceof Bombe) && !(tohit instanceof Mine) && cpt < taille) {
				tohit = list.get(cpt);
				cpt++;
			}
			if (tohit instanceof Bombe || tohit instanceof Mine) {
				Explode cmd = new Explode(terrain, tl);
				cmd.exec(tohit);
				taille = list.size();
				while (!(tohit instanceof Joueur) && !(tohit instanceof Zombie) && !(tohit instanceof Squelette)
						&& cpt < taille) {
					tohit = list.get(cpt);
					cpt++;
				}
			}
			if ((tohit instanceof Joueur) || (tohit instanceof Zombie) || (tohit instanceof Squelette)) {
				tohit.power(-e.hit());
			}
		}
		int damage = e.hit(); // renvoie les dégats que fait l'entitée a une autre. (positif)
		if (damage == -6) { // cas épée avec hitCircle
			for (int i = 1; i <= 8; i++) {
				int[] coo = terrain.next_to_outside(e, e.direction());
				if (coo[0] < 0 || coo[0] > terrain.get_ligne() - 1 || coo[1] < 0
						|| coo[1] > terrain.get_colonne() - 1) {
					int d = (e.direction() + 1) % 9;
					if (d == 0) {
						d++;
					}
					e.turn(d);
					continue;
				}
				int ligne = coo[0];
				int colonne = coo[1];
				LinkedList<Entity> list = terrain.getElement(ligne, colonne);
				int cpt = 0;
				Entity tohit = list.get(cpt);
				int taille = list.size();
				if (list.getLast() instanceof Selection)
					taille--;
				while (!(tohit instanceof Joueur) && !(tohit instanceof Zombie) && !(tohit instanceof Squelette)
						&& !(tohit instanceof Bombe) && !(tohit instanceof Mine) && cpt < taille) {
					tohit = list.get(cpt);
					cpt++;
				}
				if (tohit instanceof Bombe || tohit instanceof Mine) {
					Explode cmd = new Explode(terrain, tl);
					cmd.exec(tohit);
					taille = list.size();
					while (!(tohit instanceof Joueur) && !(tohit instanceof Zombie) && !(tohit instanceof Squelette)
							&& cpt < taille) {
						tohit = list.get(cpt);
						cpt++;
					}
				}
				if ((tohit instanceof Joueur) || (tohit instanceof Zombie) || (tohit instanceof Squelette)) {
					tohit.power(-3);
				}
				int d = (e.direction() + 1) % 9;
				if (d == 0) {
					d++;
				}
				e.turn(d);
			}
			return;
		} else if (damage == -3) { // cas Pomme
			Apple apple = (Apple) ((Joueur) e).picked();
			if (apple.poisoned()) { // true == empoisonée
				e.power(-2);
			} else {
				e.power(2);
			}
			e.resetpick();
			return;
		} else if (damage == -4) { // cas Potion
			Potion potion = (Potion) ((Joueur) e).picked();
			if (potion.poisoned()) { // true == empoisonée
				e.power(-2);
			} else {
				e.power(2);
			}
			e.resetpick();
			return;
		} else if (damage == -5) { // cas bombe
			Explode ex = new Explode(terrain, tl);
			ex.exec(((Joueur) e).picked());
			e.resetpick();
			return;
		}
		int[] coo = terrain.next_to_outside(e, e.direction());
		if (coo[0] < 0 || coo[0] > terrain.get_ligne() - 1 || coo[1] < 0 || coo[1] > terrain.get_colonne() - 1)
			return;
		int ligne = coo[0];
		int colonne = coo[1];
		LinkedList<Entity> list = terrain.getElement(ligne, colonne);
		int cpt = 0;
		Entity tohit = list.get(cpt);
		int taille = list.size();
		if (e instanceof Sable) {
			LinkedList<Entity> l_entity = terrain.getElement(e.ligne(), e.colonne());
			Entity elem;
			for (int i = 0; i < l_entity.size(); i++) {
				elem = l_entity.get(i);
				if (elem instanceof Joueur || elem instanceof Squelette || elem instanceof Zombie) {
					elem.power(-1);
					break;
				}
			}
			e.hit();
			return;
		}
		if (list.getLast() instanceof Selection)
			taille--;
		while (!(tohit instanceof Joueur) && !(tohit instanceof Zombie) && !(tohit instanceof Squelette)
				&& !(tohit instanceof Bombe) && !(tohit instanceof Mine) && cpt < taille) {
			tohit = list.get(cpt);
			cpt++;
		}
		if (tohit instanceof Bombe || tohit instanceof Mine) {
			Explode cmd = new Explode(terrain, tl);
			cmd.exec(tohit);
			taille = list.size();
			while (!(tohit instanceof Joueur) && !(tohit instanceof Zombie) && !(tohit instanceof Squelette)
					&& cpt < taille) {
				tohit = list.get(cpt);
				cpt++;
			}
		}
		if (damage > 0) {
			if ((tohit instanceof Joueur) || (tohit instanceof Zombie) || (tohit instanceof Squelette)) {
				tohit.power(-damage);
			}
		} else if (damage == -1) { // cas arc et flèche classique
			Fleche f = new Fleche(ligne, colonne, e.direction());
			terrain.add(f, ligne, colonne);
			tl.add(f);
		} else if (damage == -7) { // cas arc et flèche transpercante
			Fleche f = new Fleche(ligne, colonne, e.direction(), true);
			terrain.add(f, ligne, colonne);
			tl.add(f);
		} else if (damage == -2) { // cas Pioche
			if (tohit instanceof Labyrinthe.Void) {
				Wizz wi = new Wizz(terrain, tl);
				wi.exec(((Joueur) e).picked());
				e.resetpick();
			} else if (tohit instanceof Cassable) {
				Pop po = new Pop(terrain, tl);
				po.exec(((Joueur) e).picked());
				e.resetpick();
			} else if ((tohit instanceof Joueur) || (tohit instanceof Zombie) || (tohit instanceof Squelette)) {
				tohit.power(-2);
			}
		}
	}

	@Override
	public String toString() {
		String s = "Hit";
		return s;
	}

}
