/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.kriseev.lab3.lab3_1;

/**
 *
 * @author k17
 */
public class AnalogClock {
    protected String brandName;
    protected double price;
    private int minuteHandAngle = 0;
    private int hourHandAngle = 0; // in 1/12s of a full circle. 0 = midnight
    
    public AnalogClock(double price, String brandName)
    {
        this(0,0, price, brandName);
    }
    public AnalogClock(int initialHours, int initialMinutes, 
            double price, String brandName)
    {
        this.hourHandAngle = Math.abs(initialHours) % 12;
        this.minuteHandAngle = Math.abs(initialHours) % 60;
        this.price = Math.abs(price);
        this.brandName = brandName;
    }
    public void adjust(int hours, int minutes) throws IllegalArgumentException
    {
        if(hours < 0 || minutes < 0)
        {
            throw new IllegalArgumentException("You can't adjust time by negative value");
        }
        this.minuteHandAngle = this.minuteHandAngle + minutes;
        this.hourHandAngle = (this.hourHandAngle + hours + this.minuteHandAngle / 60) % 12;
        this.minuteHandAngle %= 60;
    }
    public double getPrice()
    {
        return this.price;
    }
    public String getBrandName()
    {
        return this.brandName;
    }
    
    public String toString()
    {
        return String.format("%s clock costs %f USD and shows time %d:%d",
                this.brandName, this.price, 
                this.hourHandAngle, this.minuteHandAngle);
    }
    
}
