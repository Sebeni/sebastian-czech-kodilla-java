package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void getLastLogTest() {
        Logger logger = Logger.getInstance();
        String message = "LOG";
        logger.log(message);
        logger = Logger.getInstance();
        
        
        String lastLog = logger.getLastLog();

        Assert.assertEquals(message, lastLog);
        
    }
}
