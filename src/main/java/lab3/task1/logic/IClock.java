package lab3.task1.logic;

import jakarta.persistence.*;

import java.io.Serializable;


@MappedSuperclass
public interface IClock extends Serializable {
	public String getBrandName();
	public void setBrandName(String name);
	public double getPrice();
	public void setPrice(Double price);
	public void addTime(Unit unit, int span) throws UnsupportedUnitTypeException, NegativeTimeAdjustmentException;
	
	public String getFormattedTime();
	
}
