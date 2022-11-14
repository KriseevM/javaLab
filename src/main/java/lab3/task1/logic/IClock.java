package lab3.task1.logic;

public interface IClock {
	public String getBrandName();

	public double getPrice();

	public void addTime(Unit unit, int span) throws UnsupportedUnitTypeException, NegativeTimeAdjustmentException;
	
	public String getFormattedTime();
	
}