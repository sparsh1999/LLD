package org.example.stock_exchange.service;

import org.example.stock_exchange.models.Order;

import java.util.Map;

public class TradeService {
    OrderService orderService;
    Map<String, TradeExecutor> executorMap;


}
