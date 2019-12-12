package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private boolean bun;
    private int burgersNum;
    private Sauce sauce;
    private List<Ingredient> ingredients;

    public Bigmac(boolean bun, int burgersNum, Sauce sauce, List<Ingredient> ingredients) {
        this.bun = bun;
        this.burgersNum = burgersNum;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public boolean isBun() {
        return bun;
    }

    public int getBurgersNum() {
        return burgersNum;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun=" + bun +
                ", burgersNum=" + burgersNum +
                ", sauce=" + sauce +
                ", ingredients=" + ingredients +
                '}';
    }

    public static class Builder {
        private boolean bun;
        private int burgersNum;
        private Sauce sauce;
        private List<Ingredient> ingredients = new ArrayList<>();

        public Builder bun(boolean bun) {
            this.bun = bun;
            return this;
        }

        public Builder burgersNum(int burgersNum) {
            this.burgersNum = burgersNum;
            return this;
        }

        public Builder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder addIngredient(Ingredient ingredient) {
            ingredients.add(ingredient);
            return this;
        }
        
        public Bigmac build() {
            if(burgersNum > 0) {
                return new Bigmac(bun, burgersNum, sauce, ingredients);
            } else {
                throw new IllegalArgumentException("No burger inside!");
            }
        }
    }
    
}
