package org.example.stock_exchange.commands;

import org.example.stock_exchange.commands.executors.OrderCommandHandler;
import org.example.stock_exchange.models.Order;
import org.example.stock_exchange.service.OrderService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    Map<Command, OrderCommandHandler> map;

    public CommandExecutorFactory() {
        this.map = new HashMap<>();
    }

    public void execute(Order order, Command command) {
        OrderCommandHandler commandHandler = map.get(command.getCommandName());
        commandHandler.execute(order, command);
    }
}
