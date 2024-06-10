package ru.job4j.polymorphism;

public class Service {
    private Store store;

    public Service(Store store) {
        this.store = store;
    }

    public void add() {
        store.save("Petr Arsentev");
    }

    public static void main(String[] args) {
        FileStore store = new FileStore();
        MemoryStore store1 = new MemoryStore();
        Service service = new Service(store);
        Service service2 = new Service(store1);
        service.add();
        service2.add();
    }
}
