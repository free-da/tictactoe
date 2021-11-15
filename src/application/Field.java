package application;

public class Field {
	private Symbol value;
	
	public Field() {
		value = Symbol.EMPTY;
	}
	public Field(final Symbol entry) {
		value = entry;
	}
	
	public Symbol getValue() {
		return value;
	}
	
	public void setFieldSymbol(Symbol symbol) {
		value = symbol;
	}
}
