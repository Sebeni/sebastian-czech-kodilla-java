package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    
    @Query(nativeQuery = true)
    List<Company> retrieveCompanyByThreeLetters(@Param("FIRST_THREE_LETTERS") String firstThreeLetters);
    
    @Query(
            value = "SELECT DISTINCT * FROM COMPANIES " +
                    "WHERE COMPANY_NAME LIKE CONCAT('%', :NAME, '%')",
            nativeQuery = true)
    List<Company> retrieveCompanyByNameFragment(@Param("NAME") String nameFragment);
    
}
