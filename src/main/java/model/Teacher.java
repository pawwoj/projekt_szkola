package model;

public class Teacher extends Person {
    Long index;

    public Teacher (String firstName, String lastName){
        super(firstName, lastName);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Teacher(String firstName, String lastName, Long index) {
        super(firstName, lastName);
        this.firstName = firstName;
        this.lastName = lastName;
        this.index = index;
    }

    @Override
    public String toString() {
        return (this.index + " " + this.firstName + " " + this.lastName);
    }
}
