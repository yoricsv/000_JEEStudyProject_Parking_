package pro.yoric.it.controller;

import pro.yoric.it.data.PersonDao;
import pro.yoric.it.pojo.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonController
{
    private PersonDao personDao;

    public PersonController()
    {
        personDao = new PersonDao();
    }

    public List<String> saveNewPerson(Person person)
    {
        List<String> validationErrors = new ArrayList<>();

        if (    person.getName() == null
             || person.getName().isEmpty())
            validationErrors.add("Name is empty");

        if(person.getId() == 0)
            person.setId(Math.round(Math.random()*1000));

        if(validationErrors.isEmpty())
            personDao.savePerson(person);

        return validationErrors;
    }
}
