package application;

public class Grid {
	private Field[][] grid;
	int NUMBEROFROWS;
	int NUMBEROFCOLUMNS;

	public Grid () {
		NUMBEROFROWS = 3;
		NUMBEROFCOLUMNS = NUMBEROFROWS;
		grid = new Field[NUMBEROFROWS][NUMBEROFCOLUMNS];
		for (int i=0; i<NUMBEROFROWS; i++) {
			for (int j=0; j<NUMBEROFCOLUMNS; j++) {
				this.grid[i][j] = new Field();
			}
		}
	}
	
	public void setFieldValue(final int rowIndex, int columnIndex, Symbol value) {
		Field field = grid[rowIndex][columnIndex];
		field.setFieldSymbol(value);
	}
	
	public Symbol getFieldValue(int rowIndex, int columnIndex) {
		Field field = grid[rowIndex][columnIndex];
		return field.getValue();
	}
	
	public boolean checkIfFieldIsEmpty(final int rowIndex, final int columnIndex) {
		if (getFieldValue(rowIndex, columnIndex) == Symbol.EMPTY) {
			return true;
		}
		return false;
	}

}
