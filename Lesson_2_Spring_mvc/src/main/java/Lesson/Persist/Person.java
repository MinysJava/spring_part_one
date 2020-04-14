package Lesson.Persist;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String firstName;

    @Column
    private String LastName;

    @Email
    @Column
    private String email;


    public Person() {
    }

    public Person(String firstName, String lastName, @Email String email) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
