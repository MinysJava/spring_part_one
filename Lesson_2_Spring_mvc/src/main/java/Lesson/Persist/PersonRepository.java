package Lesson.Persist;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    public void insert(Person person){
        em.persist(person);
    }

    public void update(Person person){
        em.merge(person);
    }

    public List<Person> getAllPersons(){
        return em.createQuery("from Person p").getResultList();
    }
}
