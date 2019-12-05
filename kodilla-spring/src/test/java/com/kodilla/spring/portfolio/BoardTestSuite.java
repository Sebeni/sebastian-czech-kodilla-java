package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

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
        
        String taskToDo = "TODO task";
        String taskDone = "DONE task";
        String taskInProgress = "IN PROGRESS task";
        
        toDoList.addTaskToList(taskToDo);
        doneList.addTaskToList(taskDone);
        inProgressList.addTaskToList(taskInProgress);
        
        String resultFromToDoList = toDoList.getTaskFromList(0);
        String resultFromDoneList = doneList.getTaskFromList(0);
        String resultFromInProgressList = inProgressList.getTaskFromList(0);

        System.out.println(resultFromToDoList + "\n" + resultFromDoneList + "\n" + resultFromInProgressList);
        
        Assert.assertEquals(taskToDo, resultFromToDoList);
        Assert.assertEquals(taskDone, resultFromDoneList);
        Assert.assertEquals(taskInProgress, resultFromInProgressList);
        
        
    }
    
}
