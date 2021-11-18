package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameboardDrawer {
	private GameboardDrawer() {
	    throw new IllegalStateException("Do not instantiate this!");
	}
	
	public static void drawGameboard(Grid grid) {
		List<String> columnCaptionValues = getColumnCaptionValues(grid);
		List<String> rowCaptionValues = getRowCaptionValues(grid);
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
		StringBuilder rowSeparatorBuilder = new StringBuilder("--"); 
		for (int columnCounter=0; columnCounter<grid.numberOfColumns; columnCounter++ ) {
			rowSeparatorBuilder.append("+---");
		}
		rowSeparatorBuilder.append("+");
		return rowSeparatorBuilder.toString();
	}

	private static ArrayList<String> makePrintableGridRows(List<String> rowCaptionValues, Grid grid) {
		ArrayList<String> printableGrid = new ArrayList<>();
		for (int i=0; i<grid.numberOfRows; i++) {
			String row = rowCaptionValues.get(i) + " |";
			for (int j=0; j<grid.numberOfColumns; j++) {
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
	
	private static String makeBeautifulColumnCaption(List<String> columnCaptionValues) {
		  StringBuilder columnCaptionBuilder = new StringBuilder();
		  columnCaptionBuilder.append("  |");
		for (int i=0; i<columnCaptionValues.size(); i++) {
			columnCaptionBuilder.append(" " + columnCaptionValues.get(i) + " |"); 
		}
		return columnCaptionBuilder.toString();
	}
	
	private static List<String> getColumnCaptionValues(Grid grid) {
		String[] columnCaptionHelper = {"A", "B", "C", "D", "E", "F"};
		String[] columnCaptionValues = Arrays.copyOf(columnCaptionHelper, grid.numberOfColumns);
		return Arrays.asList(columnCaptionValues);
	}
	private static List<String> getRowCaptionValues(Grid grid) {
		String[] rowCaptionHelper = {"1", "2", "3", "4", "5", "6"};
		String[] rowCaptionValues = Arrays.copyOf(rowCaptionHelper, grid.numberOfRows);
		return Arrays.asList(rowCaptionValues);
	}
}
