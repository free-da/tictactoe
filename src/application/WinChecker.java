package application;

public class WinChecker {
	
	private WinChecker() {
	    throw new IllegalStateException("Do not instantiate this!");
	}

	public static boolean checkIfEitherWon(Symbol symbol, Grid grid) {
		if (symbol == Symbol.X || symbol == Symbol.O) {
			
			//check for Rows
			for (int rowIndex=0; rowIndex<grid.numberOfRows; rowIndex++) {
				int rowCheckCounter = numberOfChecksInRow(symbol, grid, rowIndex);
				if (rowCheckCounter == 3) {
					return true;
				}
			}
			//check for columns
			for (int columnIndex=0; columnIndex<grid.numberOfColumns; columnIndex++) {
				int columnCheckCounter = numberOfChecksInColumn(symbol, grid, columnIndex);
				if (columnCheckCounter == 3) {
					return true;
				}
			}
			//check for diagonal
			checkForDiagonalWin(symbol, grid);
		}
		return false;
	}

	private static boolean checkForDiagonalWin(Symbol symbol, Grid grid) {
		//only works for 3x3 grid
		if (grid.getFieldValue(1, 1) == symbol) {
			if (grid.getFieldValue(0,0) == symbol && grid.getFieldValue(2, 2) == symbol) {
				return true;
			}
			if (grid.getFieldValue(0,2) == symbol && grid.getFieldValue(2, 0) == symbol) {
				return true;
			}
		}
		return false;
	}

	private static int numberOfChecksInColumn(Symbol symbol, Grid grid, int columnIndex) {
		int counter = 0;
		for (int rowIndex=0; rowIndex<grid.numberOfRows; rowIndex++) {
			if (grid.getFieldValue(rowIndex, columnIndex) == symbol) {
				counter++;
			}
		}
		return counter;
	}

	private static int numberOfChecksInRow(Symbol symbol, Grid grid, int rowIndex) {
		int counter = 0;
		for (int columnIndex=0; columnIndex<grid.numberOfColumns; columnIndex++) {
			if (grid.getFieldValue(rowIndex, columnIndex) == symbol) {
				counter++;
			}
		}
		return counter;
	}
}
