package com.aston.ecommerce.asmar.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "sub_category")
public class SubCategory extends AbstractEntity{

    @Column(name="label")
    @NotNull
    @NotEmpty
    private String label;
    @OneToMany(mappedBy = "subCategory")
    private List<Product> products;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
