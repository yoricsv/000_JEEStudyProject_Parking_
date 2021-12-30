package pro.yoric.it.service;

import pro.yoric.it.company.Company;
import pro.yoric.it.company.Employee;

import pro.yoric.it.dao.IPersonDao;
import pro.yoric.it.dao.ICompanySearchDao;

import pro.yoric.it.dto.SearchResultDto;

import pro.yoric.it.pojo.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService
{
    // INSTANCES
    @Autowired
    private ICompanySearchDao companySearchDao;
    //    private IEmployeeSearchDao employeeSearchDao;
    @Autowired
    private IPersonDao iPersonDao;


    // METHODS
    public List<SearchResultDto> searchAll(String searchParam)
    {
        List<SearchResultDto> results = new ArrayList<>();

        final List<Company>  companySearchResults  = companySearchDao.search(searchParam);
        final List<Employee> employeeSearchResults = Collections.emptyList();
        final List<Person>   personSearchResults   = iPersonDao.search(searchParam);

        results.addAll(
            companySearchResults
            .stream()
            .map(
                company ->
                    new SearchResultDto(
                        company.getId(),
                        "company",
                        company.getCompanyName()
                    )
            )
            .collect(
                Collectors.toList()
            )
        );


        results.addAll(
            personSearchResults
            .stream()
            .map(
                person ->
                    new SearchResultDto(
                        person.getId().toString(),
                        "person",
                        person.getName()        +
                        " "                     +
                        person.getSecondName()
                    )
            )
            .collect(
                Collectors.toList()
            )
        );

        return results;
    }
}
