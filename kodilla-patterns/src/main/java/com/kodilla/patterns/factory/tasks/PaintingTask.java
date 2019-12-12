package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {
    private final String name;
    private final String color;
    private final String whatToPaint;
    private boolean taskExecuted;

    public PaintingTask(String name, String color, String whatToPaint) {
        this.name = name;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        System.out.println("Painting " + whatToPaint + " with " + color + " color!");
        taskExecuted = true;
    }

    @Override
    public boolean isTaskExecuted() {
        return taskExecuted;
    }

    @Override
    public String getTaskName() {
        return name;
    }
}
