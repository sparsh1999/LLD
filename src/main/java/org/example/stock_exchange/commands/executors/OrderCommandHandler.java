package org.example.stock_exchange.commands.executors;

import org.example.stock_exchange.commands.Command;
import org.example.stock_exchange.models.Order;

public interface OrderCommandHandler {
    public void execute(Order order, Command command);
}
