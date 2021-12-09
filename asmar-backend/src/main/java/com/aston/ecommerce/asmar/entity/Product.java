package com.aston.ecommerce.asmar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product extends AbstractEntity{

    @Column(name="label")
    @NotNull
    @NotEmpty
    private String label;

    @Column(name="price")
    @NotNull
    @NotEmpty
    private Long price;

    @Column(name="description")
    @NotNull
    @NotEmpty
    private String description;

    @Column(name="size")
    private String size;

    @Column(name="quantity")
    @NotNull
    @NotEmpty
    private int quantity;
    @OneToMany
    private List<Image> urlImages;
}
