package lab3.task1.logic;

import com.google.gson.annotations.Expose;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class AnalogClock extends Clock {
	@Expose
	@Column(name = "minutes")
	protected int minutes = 0;
	@Expose
	@Column(name = "hours")
	protected int hours = 0; // in 1/12s of a full circle. 0 = midnight

	public AnalogClock(double price, String brandName) {
		this(0, 0, price, brandName);
	}

	public AnalogClock(int initialHours, int initialMinutes, double price, String brandName) {
		this.price = Math.abs(price);
		this.brandName = brandName;
		this.hours = Math.abs(initialHours) % 12;
		this.minutes = Math.abs(initialHours) % 60;
	}

	public AnalogClock() {
		this(0.0, "");
	}

	@Override
	public String toString() {
		return String.format("%s clock costs %.2f USD and shows time %02d:%02d", this.brandName, this.price,
				this.hours == 0 ? 12 : this.hours, this.minutes);
	}

	public void addTime(Unit unit, int span) throws UnsupportedUnitTypeException, NegativeTimeAdjustmentException {
		switch (unit) {
		case Hours:
			addHours(span);
			break;
		case Minutes:
			addMinutes(span);
			break;
		default:
			throw new UnsupportedUnitTypeException(unit);
		}
	}

	protected void addMinutes(int minutes) throws NegativeTimeAdjustmentException {
		if (minutes < 0) {
			throw new NegativeTimeAdjustmentException(minutes);
		}
		this.minutes = this.minutes + minutes;
		this.addHours(this.minutes / 60);
		this.minutes %= 60;
	}

	protected void addHours(int hours) throws NegativeTimeAdjustmentException {
		if (hours < 0) {
			throw new NegativeTimeAdjustmentException(hours);
		}
		this.hours += hours;
		this.hours %= 12;
	}

	@Override
	public String getFormattedTime() {
		// TODO Auto-generated method stub
		return String.format("%02d:%02d", hours, minutes);
	}
}
