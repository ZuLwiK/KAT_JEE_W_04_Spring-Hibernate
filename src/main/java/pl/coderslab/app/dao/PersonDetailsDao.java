package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.PersonDetails;
import pl.coderslab.app.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDetailsDao {
    @PersistenceContext
    EntityManager entityManager;
    public void save (PersonDetails personDetails) {
        entityManager.persist(personDetails);
    }
    public void delete (PersonDetails personDetails) {
        entityManager.remove(personDetails);
    }
    public PersonDetails findById (Long id) {
        return entityManager.find(PersonDetails.class, id);
    }
    public void update(PersonDetails personDetails) {
        entityManager.merge(personDetails);
    }
}