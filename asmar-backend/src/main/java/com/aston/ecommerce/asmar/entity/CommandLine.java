package com.aston.ecommerce.asmar.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "commandLine")
public class CommandLine extends AbstractEntity{

    @Column(name="quantity")
    @NotNull
    @NotEmpty
    private int quantity;

    @Column(name="price")
    @NotNull
    @NotEmpty
    private Long price;

    public CommandLine(int quantity, Long price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
