package com.company;

public class Calculator {
    private double stored;

    Calculator () {
        stored = 0.0;
    }
    public double getStored(){
        return stored;
    }
    public void setStored(double stored) {
        this.stored = stored;
    }
    public void add(double num) {
        stored += num;
    }
    public void minus(double stored) {
        this.stored -= stored;
    }
    public void times(double stored) {
        this.stored *= stored;
    }
    public void divide(double stored) {
        this.stored /= stored;
    }
}
