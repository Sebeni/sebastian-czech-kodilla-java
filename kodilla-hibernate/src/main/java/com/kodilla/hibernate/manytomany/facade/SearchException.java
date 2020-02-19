package com.kodilla.hibernate.manytomany.facade;

public class SearchException extends Exception {
    public final static String COMPANY_NOT_FOUND = "No company was found with this name";
    public final static String EMPLOYEE_NOT_FOUND = "No employee was found with this name";

    public SearchException(String message) {
        super(message);
    }
}
