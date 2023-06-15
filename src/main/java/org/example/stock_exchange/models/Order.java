package org.example.stock_exchange.models;

import lombok.Getter;
import org.example.stock_exchange.exception.IllegalOrderStateException;

@Getter
public class Order {
    private final String orderId;
    private final String userId;
    private final Direction orderType;
    private final String symbolId;
    private long quantity;
    private double price;
    private long orderAcceptTimestamp;
    private OrderStatus orderStatus;

    public Order(String orderId, String userId, Direction orderType, String symbolId, long quantity, double price) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderType = orderType;
        this.symbolId = symbolId;
        this.quantity = quantity;
        this.price = price;
        orderAcceptTimestamp = System.currentTimeMillis();
        orderStatus = OrderStatus.CREATED;
    }

    public void updateOrder(long quantity, double price) {
        this.quantity = quantity;
        this.price = price;
        this.orderAcceptTimestamp = System.currentTimeMillis();
    }
    public boolean isValid(long allowedDuration) {
        long currTs = System.currentTimeMillis();
        return allowedDuration >= currTs-orderAcceptTimestamp;
    }

    public void cancelOrder(){
        if (orderStatus == OrderStatus.CREATED || orderStatus == OrderStatus.CONFIRMED){
            this.orderStatus = OrderStatus.CANCELLED;
            return;
        }
        throw new IllegalOrderStateException();
    }

    public void confirmOrder() {
        if (orderStatus!=OrderStatus.CREATED){
            throw new IllegalOrderStateException();
        }
        orderStatus = OrderStatus.CONFIRMED;
    }


}
