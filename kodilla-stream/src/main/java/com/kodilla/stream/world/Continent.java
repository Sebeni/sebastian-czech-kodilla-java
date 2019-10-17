package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Continent {
    private final List<Country> countryList = new ArrayList<>();
    private final String continentName;
    
    public void addCountry(Country country){
        countryList.add(country);
    }

    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public List<Country> getCountryList() {
        return countryList;
    }
}
