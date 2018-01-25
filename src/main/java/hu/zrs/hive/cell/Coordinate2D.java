package hu.zrs.hive.cell;

public class Coordinate2D implements Coordinate {

	private final Integer x;

	private final Integer y;

	public Coordinate2D(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public Integer getX() {
		return x;
	}

	@Override
	public Integer getY() {
		return y;
	}


}
