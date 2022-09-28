/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3.task1;

/**
 *
 * @author k17
 */
public class AnalogClock extends Clock{
    private int minutes = 0;
    private int hours = 0; // in 1/12s of a full circle. 0 = midnight
    
    public AnalogClock(double price, String brandName)
    {
        this(0,0, price, brandName);
    }
    public AnalogClock(int initialHours, int initialMinutes, 
            double price, String brandName)
    {
        super(price, brandName);
        this.hours = Math.abs(initialHours) % 12;
        this.minutes = Math.abs(initialHours) % 60;
    }
    @Override
    public String toString()
    {
        return String.format("%s and shows time %02d:%02d", super.toString(),
                this.hours == 0 ? 12 : this.hours, this.minutes);
        //return String.format("%s clock costs %f USD and shows time %d:%d", this.brandName, this.price, this.hoursHandAngle, this.minutesHandAngle);
    }

    @Override
    public void addMinutes(int minutes) throws IllegalArgumentException {
        if(minutes < 0)
        {
            throw new IllegalArgumentException("You can't adjust time by negative value");
        }
        this.minutes = this.minutes + minutes;
        this.addHours(this.minutes / 60);
        this.minutes %= 60;
    }

    @Override
    public void addHours(int hours) throws IllegalArgumentException{
        if(hours < 0)
        {
            throw new IllegalArgumentException("You can't adjust time by negative value");
        }
        this.hours += hours;
        this.hours %= 12;
    }
}
