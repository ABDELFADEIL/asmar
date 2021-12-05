package com.aston.ecommerce.asmar.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    @NotNull
    @NotEmpty
    private String size;

    @Column(name="quantity")
    @NotNull
    @NotEmpty
    private int quantity;

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name="media_url")
    @NotNull
    @NotEmpty
    private String media;

    public Product(String label, Long price, String description, String size, int quantity,String media) {
        this.label = label;
        this.price = price;
        this.description = description;
        this.size = size;
        this.quantity = quantity;
        this.media = media;
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }
}
