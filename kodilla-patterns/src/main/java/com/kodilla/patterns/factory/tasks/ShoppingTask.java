package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    private final String name;
    private final String whatToBuy;
    private final double quantity;
    private boolean taskExecuted;

    public ShoppingTask(String name, String whatToBuy, double quantity) {
        this.name = name;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;                                                             
    }                                                                                         
                                                                                              
    @Override                                                                                 
    public void executeTask() {                                                               
        System.out.println("Spending money on " + quantity + " " + whatToBuy);                                        
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
