package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryAdapterTest {

    @Test
    void totalSalary() {
        Workers workers = new Workers();
        SalaryAdapter salaryAdapter = new SalaryAdapter();
        
        double totalSalary = salaryAdapter.TotalSalary(workers.getWorkers(), workers.getSalaries());
        
        assertEquals(27750.00, totalSalary);
        
        
    }
}