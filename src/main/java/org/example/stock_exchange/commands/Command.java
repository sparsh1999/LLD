package org.example.stock_exchange.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.stock_exchange.models.Order;

@AllArgsConstructor
@Getter
public class Command {
    CommandName commandName;
    CommandPayload payload;
    String orderId;
}
