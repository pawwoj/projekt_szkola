package model;

public abstract class Person {
    String firstName;
    String lastName;
    Boolean isActive;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
