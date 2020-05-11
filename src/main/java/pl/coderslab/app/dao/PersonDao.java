package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Person person){
        entityManager.persist(person);
    }

    public void updatePerson(Person person) {
        entityManager.merge(person);
    }

    public Person findPersonById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void deletePerson(Person person) {
        entityManager.remove(entityManager.contains(person) ? person : entityManager.merge(person));
    }

}