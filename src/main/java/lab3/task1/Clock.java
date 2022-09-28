/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3.task1;

/**
 *
 * @author k17
 */
public abstract class Clock implements IClock {
    protected String brandName;
    protected double price;
    
    protected Clock(double price, String brandName)
    {
        this.price = Math.abs(price);
        this.brandName = brandName;
    }
    @Override
    public double getPrice()
    {
        return this.price;
    }

    @Override
    public String getBrandName()
    {
        return this.brandName;
    }
    @Override
    public String toString()
    {
        return String.format("%s clock costs %.2f USD", this.brandName, this.price);
    }
}
