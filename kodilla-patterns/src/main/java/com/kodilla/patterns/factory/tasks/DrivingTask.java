package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {
    private final String name;
    private final String where;
    private final String using;
    private boolean taskExecuted;

    public DrivingTask(String name, String where, String using) {
        this.name = name;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() {
        System.out.println("Vroom vroom to the " + where + " by the " + using);
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
