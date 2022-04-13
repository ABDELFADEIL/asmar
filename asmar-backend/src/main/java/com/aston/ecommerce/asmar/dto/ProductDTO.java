package com.aston.ecommerce.asmar.dto;


import java.util.List;


public class ProductDTO {

    private Long id;
    private String label;
    private float price;
    private String description;
    private List<ImageDTO> urlImages;
    private CategoryDTO category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<ImageDTO> getUrlImages() {
        return urlImages;
    }

    public void setUrlImages(List<ImageDTO> urlImages) {
        this.urlImages = urlImages;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO categoryDTO) {
        this.category = categoryDTO;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", urlImages=" + urlImages +
                ", categoryDTO=" + category +
                '}';
    }
}
