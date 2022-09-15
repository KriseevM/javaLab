/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.kriseev.lab3.lab3_2;

/**
 *
 * @author k17
 */
public class Fracture {
    private int numerator = 1;
    private int denominator = 1;
    public Fracture(int integer)
    {
        this.numerator = integer;
    }
    public Fracture(int numerator, int denominator)
            throws IllegalArgumentException
    {
        if(denominator <= 0)
        {
            throw new IllegalArgumentException(String.format("Denominator must be greater than zero. Received denominator was %d", denominator));
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public void add(Fracture b)
    {
        if(this.denominator == b.denominator)
        {
            this.numerator += b.denominator;
        }
        else
        {
            this.denominator = this.denominator * b.denominator;
            this.numerator = this.numerator * b.denominator 
                    + this.denominator * b.numerator;
        }
    }
    public void mul(Fracture b)
    {
        this.denominator *= b.denominator;
        this.numerator *= b.numerator;
    }
    public void div(Fracture b)
    {
        this.denominator *= b.numerator;
        this.numerator *= b.denominator;
    }
    public String toString()
    {
        return String.format("%d/%d", this.numerator, this.denominator);
    }
}
