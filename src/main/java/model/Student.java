package model;

public class Student extends Person {
    Long indexNumber;

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName, Long indexNumber) {
        super(firstName, lastName);
        this.firstName = firstName;
        this.lastName = lastName;
        this.indexNumber = indexNumber;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
