package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class BoardTestSuite {
    @Test
    public void testBoardInitialization() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        
        Board board = context.getBean(Board.class);
        
        TaskList toDo = board.getToDoList();
        TaskList done = board.getDoneList();
        TaskList inProgress = board.getInProgressList();
        
        Assert.assertNotEquals(toDo, done);
        Assert.assertNotEquals(toDo, inProgress);
        Assert.assertNotEquals(done, inProgress);
        
    }
    
    @Test
    public void testTaskAdd() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);

        Board board = context.getBean(Board.class);

        TaskList toDoList = board.getToDoList();
        TaskList doneList = board.getDoneList();
        TaskList inProgressList = board.getInProgressList();
        
        String taskToDo = "TODO";
        String taskDone = "DONE";
        String taskInProgress = "IN PROGRESS";
        
        toDoList.addTaskToList(taskToDo);
        doneList.addTaskToList(taskDone);
        inProgressList.addTaskToList(taskInProgress);
        
        Assert.assertEquals(taskToDo, toDoList.getTaskFromList(0));
        Assert.assertEquals(taskDone, doneList.getTaskFromList(0));
        Assert.assertEquals(taskInProgress, inProgressList.getTaskFromList(0));
        
        
    }
    
}
