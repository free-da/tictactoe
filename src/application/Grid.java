package application;

public class Grid {
	private Field[][] fieldMatrix;
	final int numberOfRows;
	final int numberOfColumns;

	public Grid () {
		numberOfRows = 3;
		numberOfColumns = numberOfRows;
		fieldMatrix = new Field[numberOfRows][numberOfColumns];
		for (int i=0; i<numberOfRows; i++) {
			for (int j=0; j<numberOfColumns; j++) {
				this.fieldMatrix[i][j] = new Field();
			}
		}
	}
	
	public void setFieldValue(final int rowIndex, int columnIndex, Symbol value) {
		Field field = fieldMatrix[rowIndex][columnIndex];
		field.setFieldSymbol(value);
	}
	
	public Symbol getFieldValue(int rowIndex, int columnIndex) {
		Field field = fieldMatrix[rowIndex][columnIndex];
		return field.getValue();
	}
	
	public boolean checkIfFieldIsEmpty(final int rowIndex, final int columnIndex) {
		return (getFieldValue(rowIndex, columnIndex) == Symbol.EMPTY);
	}

}
