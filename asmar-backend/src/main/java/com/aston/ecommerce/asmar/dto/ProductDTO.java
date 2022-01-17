package com.aston.ecommerce.asmar.dto;


import com.aston.ecommerce.asmar.entity.Image;

import java.util.List;


public class ProductDTO {

    private String label;
    private float price;
    private String description;
    private List<ImageDTO> urlImages;
    private CategoryDTO categoryDTO;

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

    public List<ImageDTO> getUrlImages() {
        return urlImages;
    }

    public void setUrlImages(List<ImageDTO> urlImages) {
        this.urlImages = urlImages;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "label='" + label + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", urlImages=" + urlImages +
                ", categoryDTO=" + categoryDTO +
                '}';
    }
}
