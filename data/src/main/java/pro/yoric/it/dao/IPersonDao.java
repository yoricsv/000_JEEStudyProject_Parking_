package pro.yoric.it.dao;

import pro.yoric.it.parking.pojo.Person;

import java.io.Serializable;
import java.util.List;

public interface IPersonDao
{
    // CREATE
    Serializable savePerson(Person person);

    // READ
    List<Person> readPerson();
    List<Person> search(
        String param
    );
    List<Person> searchByNameAndSurname(
        String name,
        String surname
    );

    // DELETE
    void deletePerson(Person person);
}
