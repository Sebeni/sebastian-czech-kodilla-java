package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    
    public final Task makeTask(TasksNames taskName){
        switch(taskName){
            case DRIVING:
                return new DrivingTask(TasksNames.DRIVING.toString(), "moon", "Car");
            case PAINTING:
                return new PaintingTask(TasksNames.PAINTING.toString(), "Black", "Sky");
            case SHOPPING:
                return new ShoppingTask(TasksNames.SHOPPING.toString(), "Object", 100.01);
            default:
                return null;
        }
    }
}
