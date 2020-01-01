package com.kodilla.hibernate.tasklist.dao;


import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    private static String listName = "TestListName";
    
    @Autowired
    private TaskListDao taskListDao;
    
    @Test
    public void testFindByListName() {
        TaskList taskList = new TaskList(listName, "TEST");
        taskListDao.save(taskList);

        int id = taskList.getId();
        Optional<TaskList> savedTaskList = taskListDao.findById(id);
        List<TaskList> listWithDescription = taskListDao.findByListName(listName);
        
        
        Assert.assertTrue(savedTaskList.isPresent());
        Assert.assertEquals(1, listWithDescription.size());
        Assert.assertEquals(listName, listWithDescription.get(0).getListName());
        
        taskListDao.deleteById(id);
    }
    
    
}
