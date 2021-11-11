package ch.hslu.oop.SW07;

import java.util.Objects;

//public class Person implements Comparator<Person> {
public class Person implements Comparable<Person> {
    private final long id;
    private String lastName, firstName;

    public Person(final long id, String lastName, String firstName){
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }
    public Person(String lastName, String firstName){
        this(1, lastName, firstName);
    }

    @Override
    public String toString(){
        return "ID: " + this.id + ", Lastname: " + this.lastName + ", Firstname: " + this.firstName;
    }

    /*
    @Override
    public int compare(Person person1, Person person2) {
        if(person1.id == person2.id){
            return 0;
        }
        else if(person1.id > person2.id){
            return 1;
        }
        else{
            return -1;
        }
    }
    */

    @Override
    public final boolean equals(final Object object){
        if(!(object instanceof final Person person)){
            return false;
        }
        if(this == object){
            return true;
        }
        return (this.id == person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Person other) {
        return Long.compare(this.id, other.id);
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public long getId(){
        return id;
    }

    public static void main(String[] args) {
        Person person = new Person(1, "Hoeger", "Martin");

        System.out.println(person);
        person.setFirstName("Mertin");
        person.setLastName("Höger");
        System.out.println(person);
    }

}
