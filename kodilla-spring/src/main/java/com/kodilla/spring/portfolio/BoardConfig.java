package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {
    @Autowired
    @Qualifier("toDoTaskListNAME")
    TaskList toDo;
    
    @Autowired
    @Qualifier("inProgressTaskListNAME")
    TaskList inProgress;
    
    @Autowired
    @Qualifier("doneTaskListNAME")
    TaskList doneList;


    @Bean(name = "toDoTaskListNAME")
    public TaskList getToDoTaskList() {
        return new TaskList();
    }


    @Bean(name = "inProgressTaskListNAME")
    public TaskList getInProgressTaskList() {
        return new TaskList();
    }

    @Bean(name = "doneTaskListNAME")
    public TaskList getDoneTaskList() {
        return new TaskList();
    }
    

    @Bean
    public Board getBoard() {
        return new Board(toDo, inProgress, doneList);
    }

}
