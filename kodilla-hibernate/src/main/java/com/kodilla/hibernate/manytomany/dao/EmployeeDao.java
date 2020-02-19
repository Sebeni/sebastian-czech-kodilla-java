package com.kodilla.hibernate.manytomany.dao;


import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    @Query
    List<Employee> retrieveEmplByLastName(@Param("LASTNAME") String lastName);

    @Query(
            value = "SELECT * FROM EMPLOYEES " +
                    "WHERE FIRST_NAME LIKE :ARG OR LAST_NAME LIKE :ARG",
            nativeQuery = true)
    List<Employee> retrieveCompanyByNameFragment(@Param("ARG") String nameFragment);

}
