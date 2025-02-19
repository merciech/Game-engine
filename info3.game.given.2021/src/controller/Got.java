package controller;

import Automates.ICondition;
import Labyrinthe.Entity;
import Labyrinthe.Field;
import Labyrinthe.Inventory;

public class Got implements ICondition {

	private Field f;
	private int value;

	public Got(Field f, int value) {
		this.f = f;
		this.value = value;
	}

	public Got(Field f) {
		this.f = f;
	}

	@Override
	public boolean eval(Entity e) {
		switch (value) {
		case 0:
			if (e.picked() == null)
				return false;
			return true;
		case 1:
			int time = e.getTime();
			if (time <= 0) {
				return false;
			}
			return true;
		case 2:
			int vie = e.getVie();
			if (vie <= 0) {
				return false;
			}
			return true;
		default:
			return false;
		}
	}

	@Override
	public void setDir(int dir) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCat(int cat) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCategorie() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDirection() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setValue(int v) {
		value = v;
	}

	public int getvalue() {
		return value;
	}
	
	@Override
	public String toString() {
		String s = "Got(";
		s += Integer.toString(value);
		s += ")";
		return s;
		}
}
