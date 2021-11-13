package application.gameboard;

import java.util.ArrayList;

public class Gameboard {
	public final int NUMBEROFROWS = 3;
	public final int NUMBEROFCOLUMNS = 3;
	private Grid grid;
	
	public Gameboard() {
		grid = new Grid(NUMBEROFCOLUMNS, NUMBEROFCOLUMNS);
	}
	
	public void setFieldValue(final int rowIndex, final int columnIndex, FieldValueType value) {
		grid.setFieldValue(rowIndex, columnIndex, value);
	}
	
	public boolean checkIfFieldIsEmpty(final int rowIndex, final int columnIndex) {
		if (grid.getFieldValue(rowIndex, columnIndex) == FieldValueType.EMPTY) {
			return true;
		}
		return false;
	}
	
	public void drawGameboard() {
		ArrayList<String> columnCaptionValues = getColumnCaptionValues();
		ArrayList<String> rowCaptionValues = getRowCaptionValues();
		String printableColumnCaption = makeBeautifulColumnCaption(columnCaptionValues);
		ArrayList<String> printableGrid = makePrintableGridRows(rowCaptionValues);
		String inbetweenRows = makeBeautifulRowSeparator();
		System.out.println(printableColumnCaption);
		System.out.println(inbetweenRows);
		for (int i=0; i<printableGrid.size(); i++) {
			System.out.println(printableGrid.get(i));
			System.out.println(inbetweenRows);
		}
		System.out.println();
	}

	private String makeBeautifulRowSeparator() {
		String inbetweenRows = "--"; 
		for (int columnCounter=0; columnCounter<NUMBEROFCOLUMNS; columnCounter++ ) {
			inbetweenRows += "+---";
		}
		inbetweenRows += "+";
		return inbetweenRows;
	}

	private ArrayList<String> makePrintableGridRows(ArrayList<String> rowCaptionValues) {
		ArrayList<String> printableGrid = new ArrayList<String>();
		for (int i=0; i<NUMBEROFROWS; i++) {
			String row = rowCaptionValues.get(i) + " |";
			for (int j=0; j<NUMBEROFCOLUMNS; j++) {
				row += " " + drawFieldType(grid.getFieldValue(i,j)) + " |";
			}
			printableGrid.add(row);
		}
	
		return printableGrid;
	}
	

	private String drawFieldType(FieldValueType fieldType) {
		switch(fieldType) {
		case X:
			return "x";
		case O:
			return "O";
		case EMPTY:
			return " ";
		default:
			throw new NullPointerException();
		}
	}
	
	private String makeBeautifulColumnCaption(ArrayList<String> columnCaptionValues) {
		String columnCaption = "  |";
		for (int i=0; i<columnCaptionValues.size(); i++) {
			columnCaption += " " + columnCaptionValues.get(i) + " |"; 
		}
		return columnCaption;
	}
	
	private ArrayList<String> getColumnCaptionValues() {
		String[] columnCaptionHelper = {"A", "B", "C", "D", "E", "F"};
		ArrayList<String> columnCaptionValues = new ArrayList<String>();
		for (int j=0; j<NUMBEROFCOLUMNS; j++) {
			columnCaptionValues.add(columnCaptionHelper[j]);
		}
		return columnCaptionValues;
	}
	private ArrayList<String> getRowCaptionValues() {
		String[] rowCaptionHelper = {"1", "2", "3", "4", "5", "6"};
		ArrayList<String> rowCaptionValues = new ArrayList<String>();
		for (int j=0; j<NUMBEROFCOLUMNS; j++) {
			rowCaptionValues.add(rowCaptionHelper[j]);
		}
		return rowCaptionValues;
	}

	public boolean checkIfEitherWon(FieldValueType valueType) {
		if (valueType == FieldValueType.X || valueType == FieldValueType.O) {
			
			//check for Rows
			int counter = 0;
			for (int rowIndex=0; rowIndex<NUMBEROFROWS; rowIndex++) {
				for (int columnIndex=0; columnIndex<NUMBEROFCOLUMNS; columnIndex++) {
					if (grid.getFieldValue(rowIndex, columnIndex) == valueType) {
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
			for (int columnIndex=0; columnIndex<NUMBEROFCOLUMNS; columnIndex++) {
				for (int rowIndex=0; rowIndex<NUMBEROFROWS; rowIndex++) {
					if (grid.getFieldValue(rowIndex, columnIndex) == valueType) {
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
			if (grid.getFieldValue(1, 1) == valueType) {
				if (grid.getFieldValue(0,0) == valueType && grid.getFieldValue(2, 2) == valueType) {
					return true;
				}
				if (grid.getFieldValue(0,2) == valueType && grid.getFieldValue(2, 0) == valueType) {
					return true;
				}
			}
		}
		return false;
	}
}
