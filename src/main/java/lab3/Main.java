/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package lab3;

import java.util.Random;
import lab3.task1.AnalogClock;
import lab3.task1.AnalogClockWithSeconds;
import lab3.task1.IClock;
import lab3.task1.IClockWithSeconds;

/**
 *
 * @author k17
 */
public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        IClock clock1 = new AnalogClock(rnd.nextInt(), rnd.nextInt(), 20.0, "brand 1");
        IClockWithSeconds clock2 = new AnalogClockWithSeconds(rnd.nextInt(), rnd.nextInt(), rnd.nextInt(), 90.0, "brand 2");
        testClock(clock1);
        testClockWithSeconds(clock2);
    }
    public static void testClockWithSeconds(IClockWithSeconds clock) {
        testClock(clock);
        System.out.println("Adjusting time by 15 seconds...");
        clock.addSeconds(15);
        System.out.println(clock);
        System.out.println("Adjusting time by 45 seconds...");
        clock.addSeconds(45);
        System.out.println(clock);
        System.out.println("Adjusting time by 95 seconds...");
        clock.addSeconds(95);
        System.out.println(clock);
        System.out.println("Adjusting time by 3900 seconds...");
        clock.addSeconds(3900);
        System.out.println(clock);
    }
    public static void testClock(IClock clock) {
        System.out.println("\n ----- Starting clock test ----- \n");
        System.out.println(clock);
        System.out.println("Adjusting time by 1h and 10 minutes...");
        clock.addHours(1);
        clock.addMinutes(10);
        System.out.println(clock);
        System.out.println("Adjusting time by 10h and 50 minutes...");
        clock.addHours(10);
        clock.addMinutes(50);
        System.out.println(clock);
        System.out.println("Adjusting time by 600 minutes");
        clock.addMinutes(600);
        System.out.println(clock);
        System.out.println("Adjusting time by 25 hours");
        clock.addHours(25);
        System.out.println(clock);
    }

}
