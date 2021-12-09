package com.aston.ecommerce.asmar.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart extends AbstractEntity{

    private Integer userId;
    @OneToMany
    private List<CommandLine> commandLineList;

}
