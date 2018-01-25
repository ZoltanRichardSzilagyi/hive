package hu.zrs.hive;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import hu.zrs.hive.cell.Cell;
import hu.zrs.hive.cell.CellCoordinateCalculator;
import hu.zrs.hive.cell.CellEdgeDirection;
import hu.zrs.hive.cell.Coordinate;

public class HiveBuilder {

	private final CellCoordinateCalculator cellCoordinateCalculator = new CellCoordinateCalculator();

	Map<Integer, Cell> cellRegistry = new HashMap<>();

	public static void main(String[] args) {
		HiveBuilder builder = new HiveBuilder();
		Hive hive = builder.build(2);
		Cell origoCell = hive.getOrigo();
		printCell(origoCell);
		printCell(origoCell.getTop());
		printCell(origoCell.getTopRight());
		printCell(origoCell.getBottomRight());
		printCell(origoCell.getBottom());
		printCell(origoCell.getBottomLeft());
		printCell(origoCell.getTopLeft());

		printCell(origoCell.getTop().getTop());

		printCell(origoCell.getTop().getBottom());
	}

	private static void printCell(Cell cell) {
		System.out.println(cell.getX() + ":" + cell.getY());
	}

	public Hive build(int diameter) {
		Cell origo = createOrigo();
		buildHive(diameter, origo);
		Hive hive = new Hive(origo, cellRegistry);
		return hive;
	}

	private void buildHive(int diameter, Cell origo) {
		if (diameter == 0) {
			return;
		}
		Integer x = origo.getX();
		Integer y = origo.getY();
		for (int k = 0; k < 6; k++) {
			Coordinate newCellCoordinate = cellCoordinateCalculator.calculate(k, x, y);
			HashCodeBuilder cellKeyBuilder = new HashCodeBuilder();
			cellKeyBuilder.append(newCellCoordinate.getX());
			cellKeyBuilder.append(newCellCoordinate.getY());
			Integer coordinateKey = cellKeyBuilder.toHashCode();
			Cell cell = cellRegistry.get(coordinateKey);
			if (cell == null) {
				cell = new Cell(newCellCoordinate.getX(), newCellCoordinate.getY());
				cellRegistry.put(coordinateKey, cell);
				buildHive(diameter - 1, cell);
			}
			origo.addSurroundingCell(CellEdgeDirection.values()[k], cell);
		}
	}

	private Cell createOrigo() {
		return createCell(0, 0);
	}

	private Cell createCell(Integer x, Integer y) {
		Cell cell = new Cell(x, y);
		cellRegistry.put(cell.hashCode(), cell);
		return cell;
	}
}
