package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    private TaskFactory factory = new TaskFactory();
    private Task shopping = factory.makeTask(TasksNames.SHOPPING);
    private Task driving = factory.makeTask(TasksNames.DRIVING);
    private Task painting = factory.makeTask(TasksNames.PAINTING);
    
    @Test
    public void executingTasksTest() {
        
        boolean beforeExecution = !shopping.isTaskExecuted() && !driving.isTaskExecuted() && !painting.isTaskExecuted();
        
        shopping.executeTask();
        driving.executeTask();
        painting.executeTask();
        
        boolean afterExecution = shopping.isTaskExecuted() && driving.isTaskExecuted() && painting.isTaskExecuted();

        Assert.assertTrue(beforeExecution);
        Assert.assertTrue(afterExecution);
        
    }
    
    @Test
    public void testFactoryObjectCreation() {
        Assert.assertEquals("SHOPPING", shopping.getTaskName());
        Assert.assertEquals("DRIVING", driving.getTaskName());
        Assert.assertEquals("PAINTING", painting.getTaskName());
    }
}
