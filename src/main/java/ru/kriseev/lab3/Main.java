/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ru.kriseev.lab3;

import java.util.Random;
import ru.kriseev.lab3.lab3_2.Fracture;
/**
 *
 * @author k17
 */
public class Main {

    public static void main(String[] args) {
        int a, b, c, d;
        Random rnd = new Random();
        a = rnd.nextInt() % 100;
        b = 1+(rnd.nextInt(100));
        c = rnd.nextInt() % 100;
        d = 1+(rnd.nextInt(100));
        Fracture f1 = new Fracture(a, b);
        Fracture f2 = new Fracture(c, d);
        System.out.print("First Fracture: ");
        System.out.println(f1);
        System.out.print("Second Fracture: ");
        System.out.println(f2);
        System.out.println("Adding: ");
        f1.add(f2);
        System.out.print("f1 + f2 = ");
        System.out.println(f1);
        System.out.println("Result recorded into f1");
        
        System.out.println("Multiplying: ");
        f1.mul(f2);
        System.out.print("f1 * f2 = ");
        System.out.println(f1);
        System.out.println("Result recorded into f1");
        
        System.out.println("Dividing: ");
        f1.div(f2);
        System.out.print("f1 / f2 = ");
        System.out.println(f1);
        System.out.println("Result recorded into f1");
    }
}
