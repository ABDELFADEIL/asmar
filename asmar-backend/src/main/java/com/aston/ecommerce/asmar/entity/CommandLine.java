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
}
