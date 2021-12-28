package pro.yoric.it.service;

import pro.yoric.it.company.Company;
import pro.yoric.it.company.Employee;
import pro.yoric.it.dao.ICompanySearchDao;
import pro.yoric.it.dto.SearchResultDto;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService
{
    // INSTANCES
    private ICompanySearchDao companySearchDao;
    //    private IEmployeeSearchDao employeeSearchDao;


    // METHODS
    public List<SearchResultDto> searchAll(String searchParam)
    {
        List<SearchResultDto> results = new ArrayList<>();

        List<Company>  companySearchResults  = companySearchDao.search(searchParam);
        List<Employee> employeeSearchResults = Collections.emptyList();

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

        return results;
    }
}
