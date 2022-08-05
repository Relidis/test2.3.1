package web.Persons;

import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = Person.PERSISTANCE_NAME)
@Component
@Table(name = "person")
public class Person {
    static final String PERSISTANCE_NAME = "Person";
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ToString.Include
    @Column(name = "name")
    private String name;
    @ToString.Include
    @Column(name = "lastname")
    private String lastname;
    public Person(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Person(int id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }
}
