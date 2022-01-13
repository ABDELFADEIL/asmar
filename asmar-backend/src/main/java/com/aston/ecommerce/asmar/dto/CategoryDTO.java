package com.aston.ecommerce.asmar.dto;

import java.util.List;

public class CategoryDTO {

    private String label;

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
