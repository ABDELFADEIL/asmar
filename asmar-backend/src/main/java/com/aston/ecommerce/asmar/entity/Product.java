package com.aston.ecommerce.asmar.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product extends AbstractEntity{

    @Column(name="label", nullable = false)
    private String label;
    @Column(name="price", nullable = false)
    private float price;
    @Column(name="description", nullable = false)
    private String description;
    @Column(name="history")
    private String history;
    @Column(name="origin")
    private String origin;
    @Column(name="composition")
    private String composition;
    @Column(name="usage_")
    private String usage_;
    @Column(name="size")
    private String size;
    @Column(name="disponible", nullable = false)
    private boolean disponible;
    @Column(name="quantity")
    private long quantity;
    @OneToMany(mappedBy = "product")
    private List<Image> urlImages;
    @ManyToOne
    @JoinColumn(name="categoryId", nullable = false)
    private Category category;



    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsage_() {
        return usage_;
    }

    public void setUsage_(String usage) {
        this.usage_ = usage;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public List<Image> getUrlImages() {
        return urlImages;
    }

    public void setUrlImages(List<Image> urlImages) {
        this.urlImages = urlImages;
    }

    public String getHistory() { return history; }

    public void setHistory(String history) { this.history = history;}

    public String getOrigin() { return origin;}

    public void setOrigin(String origin) { this.origin = origin; }

    public String getComposition() { return composition; }

    public void setComposition(String composition) { this.composition = composition;}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
