package com.aston.ecommerce.asmar.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sub_category")
public class SubCategory extends AbstractEntity{

    @Column(name="label", nullable = false)
    private String label;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "subCategory")
    private List<Product> products;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
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
