package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {

     }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.message = message;
        this.status = status;
    }

    public void printInfo() {
        System.out.println("Error: " + active);
        System.out.println("Status is: " + status);
        System.out.println("Description: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error404 = new Error(true, 404, "Not Found");
        error.printInfo();
        error404.printInfo();
    }

}
