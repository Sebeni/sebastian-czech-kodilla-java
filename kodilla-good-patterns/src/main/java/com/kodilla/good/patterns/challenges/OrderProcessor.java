package com.kodilla.good.patterns.challenges;

public class OrderProcessor {
    private DisplayInfo displayInfo;
    private OrderService orderService;
    private PaymentService paymentService;
    private InStockValidator inStockValidator;

    public OrderProcessor(DisplayInfo displayInfo, OrderService orderService, PaymentService paymentService, InStockValidator inStockValidator) {
        this.displayInfo = displayInfo;
        this.orderService = orderService;
        this.paymentService = paymentService;
        this.inStockValidator = inStockValidator;
    }

    public void process(ProductOrderRequest request) {
        displayInfo.display(request.getProduct());
        if (inStockValidator.itemInStock(request.getProduct(), request.getAmount())) {
            paymentAndOrderProcess(request);
        } else {
            System.out.println("Out of stock");
        }

    }

    public void paymentAndOrderProcess(ProductOrderRequest request) {
        if(paymentService.pay(request.getProduct().getPrice() * request.getAmount())){
            orderService.placeOrder(request.getProduct(), request.getUser(), request.getAmount());
            System.out.println("Order successfully placed");
        } else {
            System.out.println("Insufficient funds");
        }
    }
}
