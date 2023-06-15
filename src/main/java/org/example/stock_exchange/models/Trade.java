package org.example.stock_exchange.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trade {
    String tradeId;
    String buyerOrderId;
    String sellerOrderId;
    String symbolId;
    long quantity;
    double price;
    long tradeTime;
}
