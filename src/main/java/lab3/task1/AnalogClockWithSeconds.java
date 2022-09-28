/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3.task1;

/**
 *
 * @author k17
 */
public class AnalogClockWithSeconds extends AnalogClock implements IClockWithSeconds {

    protected int seconds;
    public AnalogClockWithSeconds(int initialHours, int initialMinutes, 
            int initialSeconds, double price, String brandName)
    {
        super(initialHours, initialMinutes, price, brandName);
        this.seconds = Math.abs(initialSeconds) % 60;
    }
    @Override
    public void addSeconds(int seconds) throws IllegalArgumentException
    {
        if(seconds < 0)
        {
            throw new IllegalArgumentException("You can't adjust time by negative value");
        }
        this.seconds += seconds;
        this.addMinutes(this.seconds / 60);
        this.seconds %= 60;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s:%02d", super.toString(), this.seconds);
    }
}
