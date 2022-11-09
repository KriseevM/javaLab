package lab3.task1;

public class AnalogClockWithSeconds extends AnalogClock {

	@Override
	public String getFormattedTime() {
		return String.format("%s:%02d", super.getFormattedTime(), this.seconds);
	}

	protected int seconds;

	public AnalogClockWithSeconds(int initialHours, int initialMinutes, int initialSeconds, double price,
			String brandName) {
		super(initialHours, initialMinutes, price, brandName);
		this.seconds = Math.abs(initialSeconds) % 60;
	}

	@Override
	public void addTime(Unit unit, int span) throws UnsupportedUnitTypeException, NegativeTimeAdjustmentException {
		switch (unit) {
		case SECOND:
			addSeconds(span);
			break;
		default:
			super.addTime(unit, span);
		}
	}

	protected void addSeconds(int seconds) throws NegativeTimeAdjustmentException {
		if (seconds < 0) {
			throw new NegativeTimeAdjustmentException(seconds);
		}
		this.seconds += seconds;
		this.addMinutes(this.seconds / 60);
		this.seconds %= 60;
	}

	@Override
	public String toString() {
		return String.format("%s:%02d", super.toString(), this.seconds);
	}
}
