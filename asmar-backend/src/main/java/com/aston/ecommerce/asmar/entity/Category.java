package com.aston.ecommerce.asmar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category extends AbstractEntity{

    @Column(name="label")
    @NotNull
    @NotEmpty
    private String label;
}
