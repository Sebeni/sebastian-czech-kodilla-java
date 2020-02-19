package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFacade {
    private final SearchService searchService;
    private final static Logger LOGGER = LoggerFactory.getLogger(SearchFacade.class);


    public SearchFacade(SearchService searchService) {
        this.searchService = searchService;
    }

    public List<Company> searchByCompanyName(String nameFragment) throws SearchException {
        List<Company> result = searchService.retrieveCompanyByName(nameFragment);
        if (result.size() == 0) {
            LOGGER.error(SearchException.COMPANY_NOT_FOUND);
            throw new SearchException(SearchException.COMPANY_NOT_FOUND);
        } else {
            result.forEach(company -> LOGGER.info("Found company - name: " + company.getCompanyName()));
            return result;
        }
    }

    public List<Employee> searchByEmployeeName(String firstOrLastNameFragment) throws SearchException {
        List<Employee> result = searchService.retrieveEmployeeByName(firstOrLastNameFragment);
        if (result.size() == 0) {
            LOGGER.error(SearchException.EMPLOYEE_NOT_FOUND);
            throw new SearchException(SearchException.EMPLOYEE_NOT_FOUND);
        } else {
            result.forEach(employee -> LOGGER.info(
                    "Found employee - first name name: " + employee.getFirstName() + 
                    " last name: " + employee.getLastName()));
            return result;
        }
    }


}
