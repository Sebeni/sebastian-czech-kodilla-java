package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchFacadeTest {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    SearchFacade searchFacade;
    private int softwareMachineId;
    private int dataMaestersId;
    private int greyMatterId;

    @Before
    public void initData() {
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        companyDao.save(softwareMachine);
        softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        greyMatterId = greyMatter.getId();
    }

    @After
    public void cleanUp() {
        companyDao.deleteById(softwareMachineId);
        companyDao.deleteById(dataMaestersId);
        companyDao.deleteById(greyMatterId);

    }

    @Test
    public void shouldReturnGreyMatter() {
        List<Company> companies = new ArrayList<>();
        try {
            companies = searchFacade.searchByCompanyName("grey");
        } catch (Exception e) {
            e.printStackTrace();

        }

        assertEquals(1, companies.size());
        assertEquals("Grey Matter", companies.get(0).getCompanyName());

    }

    @Test
    public void shouldReturnAllCompanies() {
        List<Company> companies = new ArrayList<>();
        try {
            companies = searchFacade.searchByCompanyName("a");
        } catch (Exception e) {
            e.printStackTrace();

        }

        assertEquals(3, companies.size());
    }

    @Test(expected = SearchException.class)
    public void shouldThrowExceptionNonExistentCompany() throws SearchException {
        searchFacade.searchByCompanyName("x");
    }
    
    @Test
    public void shouldReturnJohnSearchingByFirstNameLetters() {
        List<Employee> employees = new ArrayList<>();
        try {
            employees = searchFacade.searchByEmployeeName("jo");
        } catch (Exception e) {
            e.printStackTrace();

        }

        assertEquals(1, employees.size());
        assertEquals("John", employees.get(0).getFirstName());
        assertEquals("Smith", employees.get(0).getLastName());
    }

    @Test
    public void shouldReturnStephanieSearchingByLastNameLetters() {
        List<Employee> employees = new ArrayList<>();
        try {
            employees = searchFacade.searchByEmployeeName("rck");
        } catch (Exception e) {
            e.printStackTrace();

        }

        assertEquals(1, employees.size());
        assertEquals("Stephanie", employees.get(0).getFirstName());
        assertEquals("Clarckson", employees.get(0).getLastName());
    }

    @Test
    public void shouldReturnAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try {
            employees = searchFacade.searchByEmployeeName("o");
        } catch (Exception e) {
            e.printStackTrace();

        }

        assertEquals(3, employees.size());
    }

    @Test(expected = SearchException.class)
    public void shouldThrowExceptionNonExistentEmployee() throws SearchException {
        searchFacade.searchByEmployeeName("x");
    }
    
}