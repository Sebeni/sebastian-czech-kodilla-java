package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {
    private double field;
    
    public Square(double sideLength){
        field = sideLength * sideLength;
    }


    @Override
    public String getShapeName() {
        return "square";
    }

    @Override
    public double getField() {
        return field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.field, field) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(field);
    }
}
