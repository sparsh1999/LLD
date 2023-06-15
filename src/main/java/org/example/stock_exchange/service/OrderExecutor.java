package org.example.stock_exchange.service;

import lombok.AllArgsConstructor;
import org.example.stock_exchange.commands.Command;
import org.example.stock_exchange.commands.CommandExecutorFactory;

import java.util.List;

@AllArgsConstructor
public class OrderExecutor implements Runnable{
    final String symbol;
    OrderService orderService;
    CommandExecutorFactory commandExecutorFactory;

    @Override
    public void run() {
        synchronized (symbol) {
            List<Command> commandList = orderService.getPendingOrders().get(symbol);
            for (Command command: commandList){
                commandExecutorFactory.execute(orderService.getOrderMap().get(command.getOrderId()), command);
            }
            commandList.clear();
        }
    }
}
