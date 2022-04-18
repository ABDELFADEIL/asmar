package com.aston.ecommerce.asmar.dto;


import java.util.List;

public class ProductDetailDTO {

    private Integer id;
    private String label;
    private float price;
    private String description;
    private String history;
    private String origin;
    private String composition;
    private String usage_;
    private String size;
    private boolean available;
    private long quantity;
    private List<ImageDTO> urlImages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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



    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public List<ImageDTO> getUrlImages() {
        return urlImages;
    }

    public void setUrlImages(List<ImageDTO> urlImages) {
        this.urlImages = urlImages;
    }

    public String getUsage_() {
        return usage_;
    }

    public void setUsage_(String usage_) {
        this.usage_ = usage_;
    }
}
