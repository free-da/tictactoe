package application.game;

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
		
	
	public String getFieldValue(int x, int y) {
		Field field = grid[x][y];
		switch(field.getValue()) {
		case X:
			return "x";
		case O:
			return "O";
		case EMPTY:
			return "_";
		default:
			throw new NullPointerException();
		}
	}
}
