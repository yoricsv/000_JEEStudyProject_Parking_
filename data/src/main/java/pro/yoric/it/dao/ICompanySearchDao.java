package pro.yoric.it.dao;

import pro.yoric.it.company.Company;

import java.util.List;

public interface ICompanySearchDao
{
    List<Company> search(String namePattern);
}
