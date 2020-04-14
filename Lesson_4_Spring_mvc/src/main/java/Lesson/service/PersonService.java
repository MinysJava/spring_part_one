package Lesson.service;

import Lesson.Persist.Person;
import Lesson.Persist.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void insert(Person person){
        personRepository.save(person);
    }

    @Transactional
    public void update(Person person){
        personRepository.save(person);
    }

    @Transactional(readOnly = true)
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Person> findById(Long id){
        return personRepository.findById(id);
    }
}
