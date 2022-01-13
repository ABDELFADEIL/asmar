package com.aston.ecommerce.asmar.dto;

import com.aston.ecommerce.asmar.entity.Category;
import com.aston.ecommerce.asmar.entity.Image;
import com.aston.ecommerce.asmar.entity.Product;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class ProductDTO {

    private String label;
    private float price;
    private Image image;
    private String description;
    private String history;
    private String origin;
    private String composition;
    private String usage;
    private String size;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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

    public void setUsage_(String usage) {
        this.usage = usage;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public List<ImageDTO> getUrlImages() {
        return urlImages;
    }

    public void setUrlImages(List<ImageDTO> urlImages) {
        this.urlImages = urlImages;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "label='" + label + '\'' +
                ", price=" + price +
                ", image=" + image +
                ", description='" + description + '\'' +
                ", history='" + history + '\'' +
                ", origin='" + origin + '\'' +
                ", composition='" + composition + '\'' +
                ", usage='" + usage + '\'' +
                ", size='" + size + '\'' +
                ", urlImages=" + urlImages +
                ", categoryDTO=" + categoryDTO +
                '}';
    }
}
