package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void bigmacBuilderTest() {
        Bigmac.Builder builder = new Bigmac.Builder();
        
        Bigmac result = builder.bun(true)
                .burgersNum(3)
                .addIngredient(Ingredient.ONION)
                .addIngredient(Ingredient.CHILI)
                .addIngredient(Ingredient.MUSHROOMS)
                .sauce(Sauce.BBQ)
                .build();

        System.out.println(result);

        Assert.assertEquals(3, result.getBurgersNum());
        Assert.assertEquals(3, result.getIngredients().size());
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void noBurgerExceptionTest() {
        Bigmac b = new Bigmac.Builder().burgersNum(0).build();
    }
    
}
