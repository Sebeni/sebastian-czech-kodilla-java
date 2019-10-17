package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {
    private final String countryName;
    private final BigDecimal population;

    public Country(String countryName, BigDecimal population) {
        this.countryName = countryName;
        this.population = population;
    }

    BigDecimal getPeopleQuantity(){
        return population;
    }
}
