package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape {
    private double field;

    public Triangle(double base, double height){
        field = base * height / 2;
    }


    @Override
    public String getShapeName() {
        return "triangle";
    }

    @Override
    public double getField() {
        return field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.field, field) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(field);
    }
}
