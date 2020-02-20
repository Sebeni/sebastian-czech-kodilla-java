package com.kodilla.patterns2.facade;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderWatcher.class);
    
    @Before(value = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(orderDto, userId)", argNames = "orderDto,userId")
    public void logBeforeMethod(OrderDto orderDto, Long userId){
        LOGGER.info("\nBEFORE\n processing order: " + orderDto + " for user with id: " + userId);
    }


    @After(value = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(orderDto, userId)", argNames = "orderDto,userId")
    public void logAfterMethod(OrderDto orderDto, Long userId){
        LOGGER.info("\nAFTER\n processing order: " + orderDto + " for user with id: " + userId);
    }
    
}
