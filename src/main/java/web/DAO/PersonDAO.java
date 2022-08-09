package web.DAO;

import org.springframework.stereotype.Component;
import web.Persons.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> allUsers()  {
    return entityManager.createQuery("SELECT t FROM Person t", Person.class).getResultList();
        }
    public Person oneUser(int id){

        return entityManager.find(Person.class, id);
    }
    public void save(Person person){
         entityManager.persist(person);
    }
    public void update(int id, Person updatedPerson){
      //   entityManager.merge(updatedPerson);
        Person toBeUpdated = oneUser(id);
        toBeUpdated.setName(updatedPerson.getName());
        toBeUpdated.setLastname(updatedPerson.getLastname());
        entityManager.merge(toBeUpdated);

    }
    public void delete(int id) {
        entityManager.remove(oneUser(id));
    }
}
