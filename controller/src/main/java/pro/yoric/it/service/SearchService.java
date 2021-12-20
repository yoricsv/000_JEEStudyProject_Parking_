package pro.yoric.it.service;

import pro.yoric.it.company.Company;
import pro.yoric.it.company.Employee;
import pro.yoric.it.dao.ICompanySearchDao;
import pro.yoric.it.dto.SearchResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService
{
    // INSTANCES
    private ICompanySearchDao companySearchDao;
//    private IEmployeeSearchDao employeeSearchDao;


    // METHODS
    public List<SearchResult> searchAll(String searchParam)
    {
        List<SearchResult> results = new ArrayList<>();

        List<Company> companySearchResults = companySearchDao.search(searchParam);
//        List<Employee> employeeSearchResults = Collections.emptyList();

        companySearchResults
        .stream()
        .map(
            company ->
                new SearchResult(
                        company.getId(),
                        "company",
                        company.getCompanyName()
                )
        )
        .collect(Collectors.toList());

        return results;
    }
}
