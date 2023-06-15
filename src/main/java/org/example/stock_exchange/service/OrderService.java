package org.example.stock_exchange.service;

import lombok.Getter;
import org.example.stock_exchange.commands.Command;
import org.example.stock_exchange.commands.CommandName;
import org.example.stock_exchange.commands.DefaultCommandPayload;
import org.example.stock_exchange.commands.ModifyCommandPayload;
import org.example.stock_exchange.exception.OrderNotFoundException;
import org.example.stock_exchange.models.Direction;
import org.example.stock_exchange.models.Order;

import java.util.*;

@Getter
public class OrderService {

    private final Map<String, Order> orderMap;
    private final Map<String, Map<Direction, List<Order>>> activeOrders;
    private final Map<String, List<Command>> pendingOrders;

    public OrderService() {
        this.orderMap = new HashMap<>();
        this.activeOrders = new HashMap<>();
        pendingOrders = new HashMap<>();
    }

    public Order createOrder(String userId, Direction orderType, String symbolId, long quantity, double price) {
        String orderId = UUID.randomUUID().toString();
        Order order = new Order(orderId, userId, orderType, symbolId, quantity, price);
        orderMap.put(orderId, order);
        pendingOrders.get(symbolId).add(new Command(CommandName.CREATE_ORDER, new DefaultCommandPayload(), orderId));
        return order;
    }

    public void modifyOrder(String orderId, long quantity, double price) {
        if (!orderMap.containsKey(orderId)) {
            throw new OrderNotFoundException(orderId);
        }
        Order order = orderMap.get(orderId);
        pendingOrders.get(order.getSymbolId()).add(new Command(CommandName.MODIFY_ORDER, new ModifyCommandPayload(quantity, price), orderId));
    }


}
