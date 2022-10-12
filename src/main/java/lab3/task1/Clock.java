package lab3.task1;

public abstract class Clock implements IClock {

	protected String brandName;
	protected double price;

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public String getBrandName() {
		return this.brandName;
	}
}
