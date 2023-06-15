package org.example.stock_exchange.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ModifyCommandPayload implements CommandPayload{
    long quantity;
    double price;
}
