package Labyrinthe;

public class Normal extends Mur {
	
	private int layer = 2;
	
	public Normal(int x, int y, int team, int category) {
		this.x = x;
		this.y = y;
		this.category = category;
		this.team = team;
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
		// TODO Auto-generated method stub
		return 0;
	}

}
