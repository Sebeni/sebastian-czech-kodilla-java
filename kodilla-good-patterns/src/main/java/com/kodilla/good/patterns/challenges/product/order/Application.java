package com.kodilla.good.patterns.challenges.product.order;

public class Application {
    public static void main(String[] args) {
        ProductOrderRequestRetriever retriever = new ProductOrderRequestRetriever();
        ProductOrderRequest orderRequest = retriever.retrieve();
        
        OrderProcessor processor = new OrderProcessor(new DisplayProductInfo(), new ProductOrderService(), new PaymentProductService(), new ProductInStockValidator());
        processor.process(orderRequest);
        
    }
}
