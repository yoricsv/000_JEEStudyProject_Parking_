package pro.yoric.it.service;

import pro.yoric.it.data.PersonDao;
import pro.yoric.it.pojo.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonService
{
    // CONSTRUCTORS
    public PersonService()
    {
        personDao = new PersonDao();
    }


    // GETTERS
    public List<Person> getAllPersons()
    {
        return personDao.readPerson();
    }


    // SETTERS
    public List<String> saveNewPerson(Person person)
    {
        List<String> validationErrors = new ArrayList<>();

        // Validate input params
        if (    person.getName() == null
             || person.getName().isEmpty())
            validationErrors.add("Name is empty");

        if(person.getId() == null)
            person.setId(
                Math.round(
                    Math.random() * 1000
                )
            );

        if(validationErrors.isEmpty())
            personDao.savePerson(person);

        return validationErrors;
    }

    // FIELDS
    private final PersonDao personDao;
}
