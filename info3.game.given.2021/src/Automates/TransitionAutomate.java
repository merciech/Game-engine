package Automates;

import java.util.Iterator;
import java.util.LinkedList;

import Labyrinthe.Entity;

public class TransitionAutomate {
	private State Source;
	private State Cible;
	private ICondition c;
	private LinkedList<IAction> Actions;

	public TransitionAutomate() {
		Actions = new LinkedList<IAction>();
	}

	public void add_action(IAction a) {
		Actions.add(a);
	}

	public void add_source_state(State s) {
		Source = s;
	}

	public void add_cible_state(State s) {
		Cible = s;
	}

	public void add_condition(ICondition cond) {
		c = cond;
	}

	public TransitionAutomate(State Source, State Cible, ICondition c, LinkedList<IAction> Actions) {
		this.Source = Source;
		this.Cible = Cible;
		this.c = c;
		this.Actions = Actions;
	}

	public boolean CheckCondition(Entity e) {
		return c.eval(e);
	}

	public void doActions(Entity e) {
		Iterator<IAction> iter = Actions.iterator();
		while (iter.hasNext()) {

			IAction a = iter.next();
			a.exec(e);
		}
	}

	public State getSource() {
		return Source;
	}

	public State getCible() {
		return Cible;
	}

	public ICondition getCondition() {
		return c;
	}

	public String toString() {
		String rv = "Trans : " + Source.getName() + " - " + c.toString() + " -> " + Cible.getName() + " : ";
		Iterator<IAction> i = Actions.iterator();
		while (i.hasNext()) {
			rv += i.next().toString() + ", ";
		}
		rv += "; ";
		return rv;
	}

}
