package Labyrinthe;

import toolkit.Categorie;

public class Mine extends Entity {
	
	public Mine(int x, int y) {
		this.x = x;
		this.y = y;
		this.category = Categorie.D;
		this.team = 5;
		layer = 2;
	}

	@Override
	public Entity egg(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void pop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void wizz() {
		// TODO Auto-generated method stub

	}

	@Override
	public int hit() {
		return 5;
	}

}
