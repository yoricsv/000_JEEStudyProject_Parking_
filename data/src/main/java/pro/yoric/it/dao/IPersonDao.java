package pro.yoric.it.dao;

import pro.yoric.it.pojo.Person;

import java.io.Serializable;
import java.util.List;

public interface IPersonDao
{
    List<Person> readPerson();

    Serializable savePerson(Person person);

    void deletePerson(Person person);

    List<Person> searchByNameAndSecondName(
        String name,
        String secondName
    );

    List<Person> search(String param);
}
