package Lesson.Persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByFirstName (String firstName);
    Optional<Person> findByFirstNameAndEmail (String firstName, String email);

}
