package pro.yoric.it.controller;

import pro.yoric.it.data.PersonDao;
import pro.yoric.it.pojo.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonController
{
    private final PersonDao personDao;

    public PersonController()
    {
        personDao = new PersonDao();
    }

    public List<String> saveNewPerson(Person person)
    {
        List<String> validationErrors = new ArrayList<>();

        // Validate input params
        if (    person.getName() == null
             || person.getName().isEmpty())
            validationErrors.add("Name is empty");

        if(person.getId() == null)
            person.setId(Math.round(Math.random() * 1000));

        if(validationErrors.isEmpty())
            personDao.savePerson(person);

        return validationErrors;
    }

    public List<Person> getAllPersons()
    {
        return personDao.readPerson();
    }
}
