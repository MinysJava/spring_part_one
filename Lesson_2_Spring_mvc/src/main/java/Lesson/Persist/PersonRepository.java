package Lesson.Persist;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional(propagation = Propagation.REQUIRED)
    public void insert(Person person){
        em.persist(person);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Person person){
        em.merge(person);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Person findById(Long id){
        return em.find(Person.class, id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Person> getAllPersons(){
        return em.createQuery("from Person p").getResultList();
    }
}
