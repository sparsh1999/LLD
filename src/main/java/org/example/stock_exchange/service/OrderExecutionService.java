package org.example.stock_exchange.service;

import lombok.SneakyThrows;
import org.example.stock_exchange.commands.CommandExecutorFactory;
import org.example.stock_exchange.models.Order;

import java.util.Map;

public class OrderExecutionService{
    Map<String, OrderExecutor> executorMap;
    OrderService orderService;


    @SneakyThrows
    public void notifyWorkers(Order order) {
        final String symbol = order.getSymbolId();
        if (!executorMap.containsKey(symbol)){
            executorMap.put(symbol, new OrderExecutor(symbol, orderService, new CommandExecutorFactory()));
            new Thread(executorMap.get(symbol)).start();
        }
        symbol.notify();
    }
}
