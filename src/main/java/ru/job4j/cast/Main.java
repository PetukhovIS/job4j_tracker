package ru.job4j.cast;

public class Main {
    public static void main(String[] args) {
        Vehicle airplane1 = new Airplane();
        Vehicle train1 = new Train();
        Vehicle bus1 = new Bus();
        Vehicle airplane2 = new Airplane();
        Vehicle train2 = new Train();
        Vehicle bus2 = new Bus();
        Vehicle airplane3 = new Airplane();
        Vehicle train3 = new Train();
        Vehicle bus3 = new Bus();
        Vehicle[] vehicles = new Vehicle[] {airplane1, bus1, train1,
                airplane2, bus2, train2,
                airplane3, bus3, train3};
        for (Vehicle object : vehicles) {
            object.move();
        }
    }
}

