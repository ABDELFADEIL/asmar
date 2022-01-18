package com.aston.ecommerce.asmar.dto;

import java.util.List;

public class CategoryDTO {

    private Long id;
    private String label;

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

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "label='" + label + '\'' +
                '}';
    }
}
