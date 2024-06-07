package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Petukhov Ilya Stanislavovish");
        student.setGroup("44b");
        student.setDate("01.08.2014");

        System.out.println(student.getName() + " of group "
                + student.getGroup() + " was enrolled " + student.getDate());
    }
}
