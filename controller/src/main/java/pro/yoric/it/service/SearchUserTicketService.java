package pro.yoric.it.service;

import pro.yoric.it.dao.IAppParkingUserDao;
import pro.yoric.it.dao.IPersonDao;
import pro.yoric.it.dao.ITicketDao;

import pro.yoric.it.dto.SearchTicketCriteriaDto;
import pro.yoric.it.dto.SearchTicketResultDto;

import pro.yoric.it.parking.pojo.AppParkingUser;
import pro.yoric.it.parking.pojo.Person;
import pro.yoric.it.parking.pojo.Ticket;

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
    private IAppParkingUserDao iUserDao;
    @Autowired
    private ITicketDao         iTicketDao;
    @Autowired
    private IPersonDao         iPersonDao;


    // METHOD
    public List<SearchTicketResultDto> searchUserTickets(
            SearchTicketCriteriaDto searchTicketCriteria
        )
    {
        String   fullName = searchTicketCriteria.getFullName();
        String[] names    = fullName.split(" ");

        final List<Person> personList =
            iPersonDao
            .searchByNameAndSurname(
                names[1],
                names[0]
            );
        final List<AppParkingUser> appParkingUsers =
            iUserDao
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
            iTicketDao
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
                        .setFullName(
                            ticket
                            .getPerson()
                            .getSurname() +
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
                            iUserDao
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
