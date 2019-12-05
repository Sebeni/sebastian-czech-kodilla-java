package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTaskToList(String task) {
        tasks.add(task);
    }
    
    public String getTaskFromList(int index) {
        return tasks.get(index);
    }
}
