package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        Continent asia = new Continent("Asia");
        asia.addCountry(new Country("China", new BigDecimal(1399270000)));
        asia.addCountry(new Country("India", new BigDecimal(1210854977)));
        asia.addCountry(new Country("Indonesia", new BigDecimal(261890900)));
        //2872015877
        
        Continent europe = new Continent("Europe");
        europe.addCountry(new Country("Germany", new BigDecimal(82887000)));
        europe.addCountry(new Country("France", new BigDecimal(67372000)));
        europe.addCountry(new Country("United Kingdom", new BigDecimal(66040229)));
        //216299229
        
        //3088315106
        
        World world = new World();
        world.addCountry(asia, europe);
        
        
        BigDecimal result = world.getContinents().stream()
                .flatMap(continent -> continent.getCountryList().stream()
                        .map(Country::getPeopleQuantity))
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
                    
        Assert.assertEquals(new BigDecimal("3088315106"), result);
    }
}
