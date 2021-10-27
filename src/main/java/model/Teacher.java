package model;

public class Teacher extends Person {
    Long index;

    public Teacher(Long index, String firstName, String lastName) {
        super(firstName, lastName);
        this.firstName = firstName;
        this.lastName = lastName;
        this.index = index;
    }

    public String toStringWithoutIndex() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public String toString() {
        return (this.index + " " + this.firstName + " " + this.lastName);
    }
}
