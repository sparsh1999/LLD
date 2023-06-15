package org.example.stock_exchange.exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String orderId) {
        super(String.format("Order not found for orderId: %s", orderId));
    }
}
