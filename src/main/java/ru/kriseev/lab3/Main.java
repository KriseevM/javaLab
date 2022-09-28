/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ru.kriseev.lab3;

import java.util.Random;
import ru.kriseev.lab3.lab3_1.AnalogClock;
/**
 *
 * @author k17
 */
public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        AnalogClock clock1 = new AnalogClock(rnd.nextInt(), rnd.nextInt(), 20.0, "brand 1");
        System.out.println(clock1);
        System.out.println("Adjusting time by 1h and 10 minutes...");
        clock1.adjust(-1, 10);
        System.out.println(clock1);
        System.out.println("Adjusting time by 10h and 50 minutes...");
        clock1.adjust(10, 50);
        System.out.println(clock1);
        
        System.out.println(String.format("Clock brand name: \"%s\"", clock1.getBrandName()));
        System.out.println(String.format("Clock price: %f USD", clock1.getPrice()));
        
        
    }
}
