package com.aston.ecommerce.asmar.dto;

import com.aston.ecommerce.asmar.entity.Image;

import java.util.List;

public class ProductDetailDto {

    private String label;
    private float price;
    private String description;
    private String history;
    private String origin;
    private String composition;
    private String usage;
    private String size;
    private boolean disponible;
    private long quantity;
    private List<Image> urlImages;

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

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
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
}
