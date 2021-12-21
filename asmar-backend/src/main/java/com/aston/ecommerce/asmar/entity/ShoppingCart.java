package com.aston.ecommerce.asmar.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shoppingCart")
public class ShoppingCart extends AbstractEntity{


    @OneToMany
    private List<CommandLine> commandLines;

    public List<CommandLine> getCommandLines() {
        return commandLines;
    }

    public void setCommandLines(List<CommandLine> commandLines) {
        this.commandLines = commandLines;
    }
}
