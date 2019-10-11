package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    private ArrayList<Shape> shapeList = new ArrayList<>();
    
    public void addFigure(Shape shape){
        shapeList.add(shape);
    }
    
    public String removeFigure(Shape shape){
        String message = "There is no such figure in shape list";
        
        if(shapeList.contains(shape)){
            shapeList.remove(shape);
            message = "Figure removed";
        }
        return message;
    }
    
    public Shape getFigure(int n){
        if(n < 0 || n >= shapeList.size()){
            return null;
        }
        return shapeList.get(n);
    }
    
    public String showFigures(){
        StringBuilder sb = new StringBuilder();
        
        for(Shape s : shapeList){
            sb.append(s.getShapeName()).append(" ").append(s.getField()).append(" ");
        }
        
        return sb.toString();
    }

    public ArrayList<Shape> getShapeList() {
        return shapeList;
    }
}
