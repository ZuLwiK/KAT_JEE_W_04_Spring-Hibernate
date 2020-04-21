package pl.coderslab.app.dao;

import pl.coderslab.app.entity.Person;
import pl.coderslab.app.entity.PersonDetails;
import pl.coderslab.app.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PersonDao {
    @PersistenceContext
    EntityManager entityManager;


    public void save (Person person) {
        entityManager.persist(person);
    }
    public void delete (Person person) {
        entityManager.remove(person);
    }
    public Person findById (Long id) {
        return entityManager.find(Person.class, id);
    }
    public void update(Person person) {
        entityManager.merge(person);
    }
}
