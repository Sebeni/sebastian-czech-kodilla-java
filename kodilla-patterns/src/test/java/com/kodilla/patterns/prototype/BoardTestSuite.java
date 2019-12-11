package com.kodilla.patterns.prototype;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.stream.IntStream;

public class BoardTestSuite {
    private  Board board = new Board("Project number 1");
    private  TasksList listToDo = new TasksList("To Do Tasks");
    private  TasksList listInProgress = new TasksList("In Progress Tasks");
    private  TasksList listDone = new TasksList("Done Tasks");

    @Before
    public void populateBoard() {
        //creating the TasksList for todos

        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do Task number " + n)));

        //creating the TaskList for tasks in progress

        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In Progress Task number " + n)));

        //creating the TaskList for done tasks

        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done Task number " + n)));

        //creating the board and assigning the lists
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);
    }

    @Test
    public void testToString() {
        System.out.println(board);
    }


    @Test
    public void shallowCopyTest() {
        //making a shallow clone of object board
        Board clonedBoard = null;
        try {
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(board);
        System.out.println(clonedBoard);


        //When
        board.getLists().remove(listToDo);

        //Then
        Assert.assertEquals(2, board.getLists().size());
        Assert.assertEquals(2, clonedBoard.getLists().size());
        Assert.assertEquals(clonedBoard.getLists(), board.getLists());
    }
    
    @Test
    public void deepCloneTest() {
        //making a deep copy of object board
        Board deepClonedBoard = null;
        try {
            deepClonedBoard = board.deepCopy();
            deepClonedBoard.setName("Project number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        
        
        board.getLists().remove(listToDo);
        System.out.println(board);
        System.out.println(deepClonedBoard);

        Assert.assertEquals(2, board.getLists().size());
        Assert.assertEquals(3, deepClonedBoard.getLists().size());
        Assert.assertNotEquals(deepClonedBoard.getLists(), board.getLists());
    }

}
