package lab3.task1;

public class AnalogClock extends Clock {
    private int minutes = 0;
    private int hours = 0; // in 1/12s of a full circle. 0 = midnight
    
    public AnalogClock(double price, String brandName)
    {
        this(0,0, price, brandName);
    }
    public AnalogClock(int initialHours, int initialMinutes, 
            double price, String brandName)
    {
    	this.price = Math.abs(price);
        this.brandName = brandName;
        this.hours = Math.abs(initialHours) % 12;
        this.minutes = Math.abs(initialHours) % 60;
    }
    @Override
    public String toString()
    {
        return String.format("%s clock costs %.2f USD and shows time %02d:%02d", this.brandName, this.price,
                this.hours == 0 ? 12 : this.hours, this.minutes);
    }
    public void addTime(Unit unit, int span)
    {
    	switch(unit)
    	{
    	case HOUR:
    		addHours(span);
    		break;
    	case MINUTE:
    		addMinutes(span);
    		break;
    	default:
    		throw new IllegalArgumentException("No such hand on this clock");
    	}
    }
    protected void addMinutes(int minutes) throws IllegalArgumentException {
        if(minutes < 0)
        {
            throw new IllegalArgumentException("You can't adjust time by negative value");
        }
        this.minutes = this.minutes + minutes;
        this.addHours(this.minutes / 60);
        this.minutes %= 60;
    }

    protected void addHours(int hours) throws IllegalArgumentException{
        if(hours < 0)
        {
            throw new IllegalArgumentException("You can't adjust time by negative value");
        }
        this.hours += hours;
        this.hours %= 12;
    }
}
