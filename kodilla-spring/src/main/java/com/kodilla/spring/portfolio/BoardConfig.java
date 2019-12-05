package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {
    
    @Bean
    @Scope("prototype")
    public TaskList getTaskList() {
        return new TaskList();
    }
    
    @Bean
    public Board getBoard(TaskList toDo, TaskList inProgress, TaskList doneList) {
        return new Board(toDo, inProgress, doneList);
    }

}
