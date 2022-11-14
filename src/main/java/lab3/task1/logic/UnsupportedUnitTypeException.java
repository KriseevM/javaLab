package lab3.task1.logic;

public class UnsupportedUnitTypeException extends Exception {
	private Unit unit;
	private String message;

	public UnsupportedUnitTypeException(Unit unit, String message) {
		this.unit = unit;
		this.message = message;
	}

	public UnsupportedUnitTypeException(Unit unit) {
		this(unit, String.format("This clock cannot use this unit"));
	}

	@Override
	public String toString() {
		return String.format("UnsupportedUnitTypeException: \n\tmessage: %s\n\tunit", message, unit);
	}

	public String getMessage() {
		return message;
	}

	public Unit getUnit() {
		return unit;
	}
}
