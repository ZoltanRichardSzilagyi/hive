package hu.zrs.hive.cell;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Cell implements Coordinate, Navigable {

	private final List<Cell> surroundingCells = new ArrayList<>(6);

	private final Integer x;

	private final Integer y;

	public Cell(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	public void addSurroundingCell(CellEdgeDirection direction, Cell surroundingCell) {
		surroundingCells.add(surroundingCell);
	}

	@Override
	public Integer getX() {
		return x;
	}

	@Override
	public Integer getY() {
		return y;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(x);
		builder.append(y);
		return builder.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !Cell.class.isInstance(obj)) {
			return false;
		}
		Cell otherCell = (Cell) obj;
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(x, otherCell.getX());
		builder.append(y, otherCell.getY());
		return builder.build();
	}

	@Override
	public Cell getTop() {
		return surroundingCells.get(CellEdgeDirection.TOP.ordinal());
	}

	@Override
	public Cell getTopRight() {
		return surroundingCells.get(CellEdgeDirection.TOP_RIGHT.ordinal());
	}

	@Override
	public Cell getBottomRight() {
		return surroundingCells.get(CellEdgeDirection.BOTTOM_RIGHT.ordinal());
	}

	@Override
	public Cell getBottom() {
		return surroundingCells.get(CellEdgeDirection.BOTTOM.ordinal());
	}

	@Override
	public Cell getBottomLeft() {
		return surroundingCells.get(CellEdgeDirection.BOTTOM_LEFT.ordinal());
	}

	@Override
	public Cell getTopLeft() {
		return surroundingCells.get(CellEdgeDirection.TOP_LEFT.ordinal());
	}


}
