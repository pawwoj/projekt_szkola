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
        return (this.firstName + " " + this.lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){ return lastName;}

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }


}
