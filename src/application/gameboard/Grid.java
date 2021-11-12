package application.gameboard;

public class Grid {
	private Field[][] grid;

	public Grid (int numberOfRows, int numberOfColumns) {
		grid = new Field[numberOfRows][numberOfColumns];
		for (int i=0; i<numberOfRows; i++) {
			for (int j=0; j<numberOfColumns; j++) {
				this.grid[i][j] = new Field();
			}
		}
	}
		
	public void setFieldValue(final int rowIndex, int columnIndex, FieldValueType value) {
		Field field = grid[rowIndex][columnIndex];
		field.setFieldValueType(value);
	}
	
	public FieldValueType getFieldValue(int rowIndex, int columnIndex) {
		Field field = grid[rowIndex][columnIndex];
		return field.getValue();
	}

}
