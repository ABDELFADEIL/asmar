package com.aston.ecommerce.asmar.dto;

import com.aston.ecommerce.asmar.entity.Image;
import com.aston.ecommerce.asmar.entity.Product;

import java.util.List;

public class ProductDto {

    private String productLabel;
    private float price;
    private Image image;


    public String getProductLabel() {
        return productLabel;
    }

    public void setProductLabel(String productLabel) {
        this.productLabel = productLabel;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
