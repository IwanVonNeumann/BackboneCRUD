package dao;

import domain.Person;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Iwan on 02.08.2015
 */

@Repository
public class PersonDao {

    private Map<String, Person> dataBase = new HashMap<>();
    private int sequence = 1;


    public PersonDao() {
        String[] names = {"John", "Dave", "Arthur"};
        for (String name : names) {
            save(new Person(name));
        }
    }

    public Collection<Person> getList() {
        return dataBase.values();
    }

    public Person save(Person person) {
        String id = String.valueOf(sequence++);
        person.setId(id);
        dataBase.put(id, person);
        return dataBase.get(id);
    }

    public Person update(Person person) {
        String id = person.getId();
        dataBase.put(id, person);
        return dataBase.get(id);
    }

    public void delete(String id) {
        dataBase.remove(id);
    }
}
