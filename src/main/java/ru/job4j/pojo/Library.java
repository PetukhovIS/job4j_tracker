package ru.job4j.pojo;

public class Library {

    public static void print(Book[] library) {
        for (Book books : library) {
            System.out.println(books.getName() + " - " + books.getPage());
        }
        System.out.println();
    }

    public static void print(Book[] library, String name) {
        for (Book books : library) {
            if (books.getName().equals(name)) {
                System.out.println(books.getName() + " - " + books.getPage());
            }
            System.out.println();
        }
    }

    public static void swap(Book[] library, int source, int destination) {
        Book book = library[source];
        library[source] = library[destination];
        library[destination] = book;
    }

    public static void main(String[] args) {
        Book book1 = new Book("Война и мир", 1296);
        Book book2 = new Book("Мастер и Маргарита", 512);
        Book book3 = new Book("Идиот", 640);
        Book book4 = new Book("Clean code", 608);
        Book[] library = {book1, book2, book3, book4};
        print(library);
        swap(library, 0, 3);
        print(library);
        print(library, "Clean code");
    }
}

