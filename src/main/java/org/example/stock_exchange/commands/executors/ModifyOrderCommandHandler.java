package org.example.stock_exchange.commands.executors;

import org.example.stock_exchange.commands.Command;
import org.example.stock_exchange.commands.ModifyCommandPayload;
import org.example.stock_exchange.models.Order;

public class ModifyOrderCommandHandler implements OrderCommandHandler{

    @Override
    public void execute(Order order, Command command) {
        ModifyCommandPayload modifyCommandPayload = (ModifyCommandPayload) command.getPayload();
        order.updateOrder(modifyCommandPayload.getQuantity(), modifyCommandPayload.getPrice());
    }
}
