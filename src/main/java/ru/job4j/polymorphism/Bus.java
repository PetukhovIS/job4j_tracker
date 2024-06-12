package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("The bus is coming");
    }

    @Override
    public void passenger(int number) {
        System.out.println("There are " + number + " passengers in the bus.");
    }

    @Override
    public double refuel(int quantity) {
     return quantity * 47.20;
    }
}
