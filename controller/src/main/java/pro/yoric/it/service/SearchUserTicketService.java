package pro.yoric.it.service;

import pro.yoric.it.dao.IAppParkingUserDao;
import pro.yoric.it.dao.IPersonDao;
import pro.yoric.it.dao.ITicketDao;

import pro.yoric.it.dto.SearchTicketCriteriaDto;
import pro.yoric.it.dto.SearchTicketResultDto;

import pro.yoric.it.pojo.AppParkingUser;
import pro.yoric.it.pojo.Person;
import pro.yoric.it.pojo.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchUserTicketService
{
    // INSTANCES
    @Autowired
    private IAppParkingUserDao userDao;
    @Autowired
    private ITicketDao         ticketDao;
    @Autowired
    private IPersonDao         personDao;


    // METHOD
    public List<SearchTicketResultDto> searchUserTickets(
            SearchTicketCriteriaDto searchTicketCriteria
        )
    {
        String   fio   = searchTicketCriteria.getFio();
        String[] names = fio.split(" ");

        final List<Person> personList =
            personDao
            .searchByNameAndSecondName(
                names[1],
                names[0]
            );
        final List<AppParkingUser> appParkingUsers =
            userDao
            .searchByAppParkingUserLogin(
                searchTicketCriteria
                .getLogin()
            );
        final Set<Long> personIds = new HashSet<>();

        personList
        .forEach(
            person ->
                personIds
                .add(
                    person
                    .getId()
                )
        );

        appParkingUsers
        .forEach(
            appParkingUser ->
                personIds
                .add(
                    appParkingUser
                    .getPerson()
                    .getId()
                )
        );

        final List<Ticket> tickets =
            ticketDao
            .findByPersonId(
                personIds
            );

        return
            tickets
            .stream()
            .filter(
                Objects::nonNull
            )
            .map(
                ticket ->
                    {
                        SearchTicketResultDto result =
                            new SearchTicketResultDto();

                        result
                        .setTicket(
                            ticket
                            .getCarNumber()
                        );

                        result
                        .setFio(
                            ticket
                            .getPerson()
                            .getSecondName() +
                            " "              +
                            ticket
                            .getPerson()
                            .getName()
                        );

                        result
                        .setPersonId(
                            ticket
                            .getPerson()
                            .getId()
                            .toString()
                        );

                        result
                        .setLogin(
                            userDao
                            .findUserByPersonId(
                                ticket
                                .getPerson()
                                .getId()
                            )
                        );

                        return result;
                    }
            )
            .collect(
                Collectors
                .toList()
            );
    }
}
