package dao;

import domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Iwan on 03.04.2016
 */

public interface PersonRepository extends CrudRepository<Person, String> {
}
