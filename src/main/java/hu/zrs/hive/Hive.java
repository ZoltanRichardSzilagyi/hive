package hu.zrs.hive;

import java.util.Map;

import hu.zrs.hive.cell.Cell;

public class Hive {

	private final Cell origo;

	Map<Integer, Cell> cellRegistry;

	public Hive(Cell origo, Map<Integer, Cell> cellRegistry) {
		this.origo = origo;
		this.cellRegistry = cellRegistry;
	}

	public Cell getOrigo() {
		return origo;
	}

}
