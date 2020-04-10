package Lesson.Persist;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonExample {
    public static void main(String[] args) {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = factory.createEntityManager();

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Tel", "1112223334"));
        contacts.add(new Contact("Adress", "sdfsfsf"));
        Person person = new Person("ivan","ivanov", LocalDate.of(1995, 2, 18), contacts);

        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } catch (Exception ex){
            em.getTransaction().rollback();
        }
        System.out.println(person);

//        em.getTransaction().begin();
//        person.setFirstName("peter");
//        em.merge(person);
//        em.getTransaction().commit();
//
//        System.out.println(person);

        Person person1 = em.find(Person.class, 2L);
        System.out.println(person1);

        List<Person> persons = em.createQuery("from Person p join fetch p.contacts c").getResultList();
        persons.forEach(System.out::println);

        em.close();

    }
}
