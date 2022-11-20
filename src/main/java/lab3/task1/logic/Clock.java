package lab3.task1.logic;

public abstract class Clock implements IClock {
	protected String brandName;
	protected double price;

	public Clock(double price, String name)
	{
		this.price = price;
		this.brandName = name;
	}

	public Clock() {
		this.price = 0.0;
		this.brandName = "";
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public String getBrandName() {
		return this.brandName;
	}

	@Override
	public void setBrandName(String name) {
		this.brandName = name.trim();
	}

	@Override
	public void setPrice(Double price)
	{
		this.price = price;
	}
}
