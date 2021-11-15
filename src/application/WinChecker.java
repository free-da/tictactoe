package application;

public class WinChecker {

	public static boolean checkIfEitherWon(Symbol symbol, Grid grid) {
		if (symbol == Symbol.X || symbol == Symbol.O) {
			
			//check for Rows
			int counter = 0;
			for (int rowIndex=0; rowIndex<grid.NUMBEROFROWS; rowIndex++) {
				for (int columnIndex=0; columnIndex<grid.NUMBEROFCOLUMNS; columnIndex++) {
					if (grid.getFieldValue(rowIndex, columnIndex) == symbol) {
						counter++;
					}
				}
				if (counter == 3) {
					return true;
				}
				else {
					counter = 0;
				}
			}
			//check for columns
			for (int columnIndex=0; columnIndex<grid.NUMBEROFCOLUMNS; columnIndex++) {
				for (int rowIndex=0; rowIndex<grid.NUMBEROFROWS; rowIndex++) {
					if (grid.getFieldValue(rowIndex, columnIndex) == symbol) {
						counter++;
					}
				}
				if (counter == 3) {
					return true;
				}
				else {
					counter = 0;
				}
			}
			//check for diagonal
			//only works for 3x3 grid
			if (grid.getFieldValue(1, 1) == symbol) {
				if (grid.getFieldValue(0,0) == symbol && grid.getFieldValue(2, 2) == symbol) {
					return true;
				}
				if (grid.getFieldValue(0,2) == symbol && grid.getFieldValue(2, 0) == symbol) {
					return true;
				}
			}
		}
		return false;
	}
}
