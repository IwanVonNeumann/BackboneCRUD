package controller;

import dao.PersonRepository;
import domain.Person;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;

/**
 * Created by Iwan on 01.06.2015
 */

@Controller
public class BackboneController {

    private final Logger log = Logger.getLogger(BackboneController.class);

    @Autowired
    PersonRepository personDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "index";
    }

    @RequestMapping(value = "/contacts", produces = "application/json", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Collection<Person> getContactsList() {
        return (Collection<Person>) personDao.findAll();
    }

    @RequestMapping(value = "/contacts", produces = "application/json", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Person save(@RequestBody Person person) {
        return personDao.save(person);
    }

    @RequestMapping(value = "/contacts/{id}", produces = "application/json", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Person update(@RequestBody Person person) {
        return personDao.save(person);
    }

    @RequestMapping(value = "/contacts/{id}", produces = "application/json", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        personDao.delete(id);
    }
}
