package com.kodilla.patterns2.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class ShopService {
    private final List<Order> orders = new ArrayList<>();
    
    @Autowired
    private Authenticator authenticator;
    
    @Autowired
    private ProductService productService;
    
    public Long openOrder(Long userId) {
        if(authenticator.isAuthenticated(userId)) {
            Long maxOrderId = (long) orders.stream()
                    .mapToInt(value -> value.getOrderId().intValue())
                    .max().orElse(0);
            
            orders.add(new Order(productService, maxOrderId + 1, userId));
            return maxOrderId + 1;
        } else {
            return -1L;
        }
    }
    
    public void addItem(long orderId, Long productId, double qty) {
        orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .forEach(order -> order.getItems().add(new Item(productId, qty)));
    }
    
    public boolean removeItem(Long orderId, Long productId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        
        while(orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            int orderSize = theOrder.getItems().size();
            for (int i = 0; i < theOrder.getItems().size(); i++) {
                if(theOrder.getItems().get(i).getProductId().equals(productId)) {
                    theOrder.getItems().remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    
    public BigDecimal calculateValue(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        
        while(orderIterator.hasNext()) {
            Order order = orderIterator.next();
            return order.calculateValue();
        }
        return BigDecimal.ZERO;
    }
    
    public boolean doPayment(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        
        while(orderIterator.hasNext()) {
            Order order = orderIterator.next();
            if(order.isPaid()) {
                return true;
            } else {
                order.setPaid(new Random().nextBoolean());
                return order.isPaid();
            }
        }
        return false;
    }
    
    public boolean verifyOrder(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();

        while(orderIterator.hasNext()) {
            Order order = orderIterator.next();
            boolean result = order.isPaid();
            Random generator = new Random();
            if(!order.isVerified()) {
                order.setVerified(result && generator.nextBoolean());
            }
            return order.isVerified();
        }
        return false;
    }
    
    public boolean submitOrder(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        while(orderIterator.hasNext()) {
            Order order = orderIterator.next();
            if(order.isVerified()) {
                order.setSubmitted(true);
            }
            return order.isSubmitted();
        }
        return false;
    }
    
    public void cancelOrder(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        while(orderIterator.hasNext()) {
            Order order = orderIterator.next();
            orders.remove(order);
        }
    }
    
    
}
