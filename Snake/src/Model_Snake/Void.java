package Model_Snake;

public class Void extends Entity {

	public Void(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	void egg(int x, int y) {
		new Void(x, y);

	}

}