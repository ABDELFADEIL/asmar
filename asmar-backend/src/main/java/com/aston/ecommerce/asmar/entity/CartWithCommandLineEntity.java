package com.aston.ecommerce.asmar.entity;


import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)

public class CartWithCommandLineEntity extends Cart{
    private List<CommandLine> commandLines;

    public CartWithCommandLineEntity(Cart cart, List<CommandLine> commandLines) {
        super(cart.getId(), cart.getUser(), cart.isCartStatus(),cart.getCharge(), cart.getTotalPrice(), cart.getCreatedDate());
        this.commandLines = commandLines;
    }

}
