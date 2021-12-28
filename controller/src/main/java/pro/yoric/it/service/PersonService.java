package pro.yoric.it.service;

import pro.yoric.it.dao.IAppParkingUserDao;
import pro.yoric.it.dao.IPersonDao;

import pro.yoric.it.dto.AddNewUserCommandDto;

import pro.yoric.it.pojo.AppParkingUser;
import pro.yoric.it.pojo.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService
{
    // INSTANCES
    @Autowired
    private IAppParkingUserDao iUserDao;
    @Autowired
    private IPersonDao         iPersonDao;


    // GETTERS
    public List<Person> getAllPersons()
    {
        return iPersonDao.readPerson();
    }


    // SETTERS
    public List<String> saveNewPerson(Person person)
    {
        List<String> validationErrors = new ArrayList<>();

        // Validate input params
        if (    person.getName() == null
             || person.getName().isEmpty()
        )
            validationErrors.add("Name is empty");

        if(person.getId() == null)
            person.setId(
                Math.round(
                    Math.random() * 1000
                )
            );

        if(validationErrors.isEmpty())
            iPersonDao.savePerson(person);

        return validationErrors;
    }

    public List<String> addNewUser(AddNewUserCommandDto command)
    {
        AppParkingUser user   = new AppParkingUser();
        Person         person = new Person();

        person.setName(command.getName());
        person.setSecondName(command.getSecondName());

        List<String> errors = saveNewPerson(person);

        if (errors.isEmpty())
        {
            user.setPerson(person);

            user.setAppParkingUserLogin(command.getLogin());
            user.setAppParkingUserPassword(command.getPassword());

            iUserDao.saveUser(user);
        }

        return errors;
    }
}
