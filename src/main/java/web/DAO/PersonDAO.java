package web.DAO;

import org.springframework.stereotype.Component;
import web.Persons.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Component
public class PersonDAO {


    private EntityManager entityManager;

    public List<Person> allUsers()  {
    return entityManager.createQuery("SELECT t.* FROM `schema_2.3.1`.person t", Person.class).getResultList();
        }
    public Person oneUser(int id){

        return entityManager.find(Person.class, id);
    }
    public void save(Person person){
         entityManager.persist(person);
    }
    public void update(int id, Person updatedPerson){
         entityManager.merge(updatedPerson);

    }
    public void delete(int id) {
         entityManager.remove(oneUser(id));
    }
}
