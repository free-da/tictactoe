package application.game;

import java.util.ArrayList;

public class Gameboard {
	private int NUMBEROFROWS = 3;
	private int NUMBEROFCOLUMNS = 3;
	
	public void drawGameboard() {
		ArrayList columnCaptionValues = getColumnCaptionValues();
		ArrayList rowCaptionValues = getRowCaptionValues();
		String printableColumnCaption = makeBeautifulColumnCaption(columnCaptionValues);
		System.out.println(printableColumnCaption);
		for (int i=0; i<NUMBEROFROWS; i++) {
			System.out.print(rowCaptionValues.get(i) + " /");
			for (int j=0; j<NUMBEROFCOLUMNS; j++) {
				System.out.print(" _ /");
			}
			System.out.print("\n");
		}
	}
	
	private String makeBeautifulColumnCaption(ArrayList columnCaptionValues) {
		String columnCaption = "  /";
		for (int i=0; i<columnCaptionValues.size(); i++) {
			columnCaption += " " + columnCaptionValues.get(i) + " /"; 
		}
		return columnCaption;
	}
	
	private ArrayList getColumnCaptionValues() {
		String[] columnCaptionHelper = {"A", "B", "C", "D", "E", "F"};
		ArrayList<String> columnCaptionValues = new ArrayList<String>();
		for (int j=0; j<NUMBEROFCOLUMNS; j++) {
			columnCaptionValues.add(columnCaptionHelper[j]);
		}
		return columnCaptionValues;
	}
	private ArrayList getRowCaptionValues() {
		String[] rowCaptionHelper = {"1", "2", "3", "4", "5", "6"};
		ArrayList<String> rowCaptionValues = new ArrayList<String>();
		for (int j=0; j<NUMBEROFCOLUMNS; j++) {
			rowCaptionValues.add(rowCaptionHelper[j]);
		}
		return rowCaptionValues;
	}
}
