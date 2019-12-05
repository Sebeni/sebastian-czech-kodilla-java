package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {
    @Autowired
    @Qualifier("toDoTaskList")
    TaskList toDo;
    
    @Autowired
    @Qualifier("inProgressTaskList")
    TaskList inProgress;
    
    @Autowired
    @Qualifier("doneTaskList")
    TaskList doneList;


    @Bean(name = {"toDoTaskList", "inProgressTaskList", "doneTaskList"})
    @Scope("prototype")
    public TaskList getTaskList() {
        return new TaskList();
    }

    @Bean
    public Board getBoard() {
        return new Board(toDo, inProgress, doneList);
    }

}
