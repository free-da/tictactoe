package application;

import java.util.ArrayList;

public class GameboardDrawer {
	
	public static void drawGameboard(Grid grid) {
		ArrayList<String> columnCaptionValues = getColumnCaptionValues(grid);
		ArrayList<String> rowCaptionValues = getRowCaptionValues(grid);
		String printableColumnCaption = makeBeautifulColumnCaption(columnCaptionValues);
		ArrayList<String> printableGrid = makePrintableGridRows(rowCaptionValues, grid);
		String inbetweenRows = makeBeautifulRowSeparator(grid);
		System.out.println(printableColumnCaption);
		System.out.println(inbetweenRows);
		for (int i=0; i<printableGrid.size(); i++) {
			System.out.println(printableGrid.get(i));
			System.out.println(inbetweenRows);
		}
		System.out.println();
	}

	private static String makeBeautifulRowSeparator(Grid grid) {
		String inbetweenRows = "--"; 
		for (int columnCounter=0; columnCounter<grid.NUMBEROFCOLUMNS; columnCounter++ ) {
			inbetweenRows += "+---";
		}
		inbetweenRows += "+";
		return inbetweenRows;
	}

	private static ArrayList<String> makePrintableGridRows(ArrayList<String> rowCaptionValues, Grid grid) {
		ArrayList<String> printableGrid = new ArrayList<String>();
		for (int i=0; i<grid.NUMBEROFROWS; i++) {
			String row = rowCaptionValues.get(i) + " |";
			for (int j=0; j<grid.NUMBEROFCOLUMNS; j++) {
				row += " " + drawFieldType(grid.getFieldValue(i,j)) + " |";
			}
			printableGrid.add(row);
		}
	
		return printableGrid;
	}
	

	private static String drawFieldType(Symbol fieldType) {
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
	
	private static String makeBeautifulColumnCaption(ArrayList<String> columnCaptionValues) {
		String columnCaption = "  |";
		for (int i=0; i<columnCaptionValues.size(); i++) {
			columnCaption += " " + columnCaptionValues.get(i) + " |"; 
		}
		return columnCaption;
	}
	
	private static ArrayList<String> getColumnCaptionValues(Grid grid) {
		String[] columnCaptionHelper = {"A", "B", "C", "D", "E", "F"};
		ArrayList<String> columnCaptionValues = new ArrayList<String>();
		for (int j=0; j<grid.NUMBEROFCOLUMNS; j++) {
			columnCaptionValues.add(columnCaptionHelper[j]);
		}
		return columnCaptionValues;
	}
	private static ArrayList<String> getRowCaptionValues(Grid grid) {
		String[] rowCaptionHelper = {"1", "2", "3", "4", "5", "6"};
		ArrayList<String> rowCaptionValues = new ArrayList<String>();
		for (int j=0; j<grid.NUMBEROFCOLUMNS; j++) {
			rowCaptionValues.add(rowCaptionHelper[j]);
		}
		return rowCaptionValues;
	}
}
