package application.gameboard;

public class Field {
	private FieldValueType value;
	
	public Field() {
		value = FieldValueType.EMPTY;
	}
	public Field(final FieldValueType entry) {
		value = entry;
	}
	
	public FieldValueType getValue() {
		return value;
	}
	
	public void setFieldValueType(FieldValueType valueType) {
		value = valueType;
	}
}
