package com.kodilla.hibernate.manytomany.facade;


import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    public SearchService(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }
    
    public List<Company> retrieveCompanyByName(String nameFragment) {
        return companyDao.retrieveCompanyByNameFragment(nameFragment);
    }
    
    public List<Employee> retrieveEmployeeByName(String firstOrLastNameFragment) {
        return employeeDao.retrieveCompanyByNameFragment(firstOrLastNameFragment);
    }
}
