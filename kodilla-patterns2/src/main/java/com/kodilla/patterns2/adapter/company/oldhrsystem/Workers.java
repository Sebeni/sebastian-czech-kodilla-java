package com.kodilla.patterns2.adapter.company.oldhrsystem;

public class Workers {
    private String[][] workers = {
            {"1234", "John", "Smith"},
            {"4567", "Joe", "Xy"},
            {"7891", "Walter", "White"},
            {"1011", "Jessie", "Pinkman"},
            {"1213", "Clara", "Smith"}
    };
    private double[] salaries = {
            4500.00,
            3700.00,
            4350.00,
            9000.00,
            6200.00
    };
    
    public String getWorker(int n) {
        if(n >= salaries.length) {
            return "";
        }
        return String.format("PESEL %s, FIRST NAME %s, LAST NAME %s, SALARY %.2f PLN", workers[n][1], workers[n][2], workers[n][3], salaries[n]);
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
