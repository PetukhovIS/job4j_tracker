package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return divide(a) + sum(a) + minus(a) + multiply(a);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println("sum " + result);
        result = minus(10);
        System.out.println("minus " + result);
        Calculator calculator = new Calculator();
        result = calculator.multiply(10);
        System.out.println("multiply " + result);
        result = calculator.divide(10);
        System.out.println("divide " + result);
        result = calculator.sumAllOperation(10);
        System.out.println("sumAll " + result);
    }
}
