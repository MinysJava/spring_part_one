package Lesson.Persist;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class PersonRepository {

    private final AtomicInteger identity = new AtomicInteger(0);

    private final List<Person> persons = new ArrayList<>();

    public PersonRepository() {
        insert(new Person("Ivan", "Ivan"));
        insert(new Person("petr", "Petr"));
        insert(new Person("Semen", "semen"));
    }

    public void insert(Person person){
        person.setId(identity.incrementAndGet());
        persons.add(person);
    }

    public List<Person> getAllPersons(){
        return Collections.unmodifiableList(persons);
    }
}
