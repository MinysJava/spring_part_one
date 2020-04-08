package Lesson.persist;

public class Person {

    private int id;

    private String firstName;
    private String LastName;

    public Person() {
    }

    public Person( String firstName, String lastName) {

        this.firstName = firstName;
        this.LastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setId(int incrementAndGet) {
        id = incrementAndGet;
    }

    public int getId() {
        return id;
    }
}
