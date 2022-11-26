package lab3.task1.logic;

import jakarta.persistence.*;


@MappedSuperclass
public interface IClock {
	public String getBrandName();
	public void setBrandName(String name);
	public double getPrice();
	public void setPrice(Double price);
	public void addTime(Unit unit, int span) throws UnsupportedUnitTypeException, NegativeTimeAdjustmentException;
	
	public String getFormattedTime();
	
}
