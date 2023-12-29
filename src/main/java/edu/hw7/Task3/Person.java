package edu.hw7.Task3;

public record Person(int id, String name, String address, String phoneNumber) {

    public Person {
        if (id < 0 || name == null || address == null || phoneNumber == null
        || name.isEmpty() || address.isEmpty() || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Один или несколько параметров не заполнены");
        }
    }
}
