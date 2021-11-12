package application.gameboard;

import java.util.ArrayList;

public class Gameboard {
	public final int NUMBEROFROWS = 3;
	public final int NUMBEROFCOLUMNS = 3;
	private Grid grid;
	
	public Gameboard() {
		grid = new Grid(NUMBEROFROWS, NUMBEROFCOLUMNS);
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
		System.out.println(printableColumnCaption);
		for (int i=0; i<printableGrid.size(); i++) {
			System.out.println(printableGrid.get(i));
		}
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
			return "_";
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
}