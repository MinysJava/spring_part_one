package Lesson.service;

import Lesson.Persist.Person;
import Lesson.Persist.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void insert(Person person){
        personRepository.insert(person);
    }

    @Transactional
    public void update(Person person){
        personRepository.update(person);
    }

    @Transactional(readOnly = true)
    public List<Person> getAllPersons(){
        return personRepository.getAllPersons();
    }

    @Transactional(readOnly = true)
    public Person findById(Long id){
        return personRepository.findById(id);
    }
}
