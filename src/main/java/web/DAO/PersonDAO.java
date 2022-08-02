package web.DAO;

import org.springframework.stereotype.Component;
import web.Persons.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int iterateId;
    private List<Person> people;
    {
        people= new ArrayList<>();
        people.add(new Person(++iterateId,"nam","vam"));
        people.add(new Person(++iterateId,"tam","pam"));
        people.add(new Person(++iterateId,"num","vim"));
        people.add(new Person(++iterateId,"zam","ram"));
    }
    public List<Person> allUsers(){
        return people;
    }
    public Person oneUser(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
    public void save(Person person){
        person.setId(++iterateId);
        people.add(person);
    }
    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = oneUser(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setName(updatedPerson.getLastname());
    }

}
