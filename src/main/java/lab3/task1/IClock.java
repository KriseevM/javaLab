/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab3.task1;

/**
 *
 * @author k17
 */
public interface IClock {
    public String getBrandName();
    public double getPrice();
    
    public void addMinutes(int minutes);
    public void addHours(int hours);
}
