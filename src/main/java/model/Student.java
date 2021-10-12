package model;

public class Student extends Person{
    String firstName;
    String lastName;
    String indexNumber;

    public Student(String firstName, String lastName, String indexNumber) {
        super(firstName, lastName);
        this.firstName = firstName;
        this.lastName = lastName;
        this.indexNumber = indexNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.indexNumber;
    }

    /*
    private -> domyslny w Javie modyfikator dostepu -> mowi on ze dostep do zmiennej/metody jest tylko z wewnatrz klasy
    public -> mowi on ze dostep do zmiennej/metody jest rowniez z zewnatrz klasy
     -- protected --
     -- default --
     this -> wskaznik na samego siebie
     int a = 5; -> a to zmienna typu int o wartosci 5
     int *b = &a; -> b to wskaznik na adres w pamieci zmiennej typu b
     this -> wskaznik na adres w pamieci samego siebie
     KAZDY obiekt javowy dziedziczy po klasie Object
     */
}
