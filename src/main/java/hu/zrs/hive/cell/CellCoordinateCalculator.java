package hu.zrs.hive.cell;

public class CellCoordinateCalculator {

	public Coordinate calculate(Integer direction, Integer x, Integer y) {
		Coordinate coordinate = null;
		CellEdgeDirection edgeDirection = CellEdgeDirection.values()[direction];
		switch (edgeDirection) {
		case TOP:
			coordinate = getTop(x, y);
			break;
		case TOP_RIGHT:
			coordinate = getTopRight(x, y);
			break;
		case BOTTOM_RIGHT:
			coordinate = getBottomRight(x, y);
			break;
		case BOTTOM:
			coordinate = getBottom(x, y);
			break;
		case BOTTOM_LEFT:
			coordinate = getBottomLeft(x, y);
			break;
		case TOP_LEFT:
			coordinate = getTopLeft(x, y);
			break;
		}
		return coordinate;

	}

	public Coordinate getTop(Integer x, Integer y) {
		return new Coordinate2D(x, y + 1);

	}

	public Coordinate getTopRight(Integer x, Integer y) {
		return new Coordinate2D(x + 1, y + 1);
	}

	public Coordinate getBottomRight(Integer x, Integer y) {
		return new Coordinate2D(x + 1, y - 1);
	}

	public Coordinate getBottom(Integer x, Integer y) {
		return new Coordinate2D(x, y - 1);

	}

	public Coordinate getBottomLeft(Integer x, Integer y) {
		return new Coordinate2D(x - 1, y - 1);

	}

	public Coordinate getTopLeft(Integer x, Integer y) {
		return new Coordinate2D(x - 1, y + 1);

	}


}
