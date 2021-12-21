package com.aston.ecommerce.asmar.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "image")
public class Image extends AbstractEntity{

    @Column(name="url", nullable = false)
    private String url;
    @ManyToOne
    @JoinColumn(name= "product_id")
    private Product product;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
