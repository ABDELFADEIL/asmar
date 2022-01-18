package com.aston.ecommerce.asmar.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "image")
public class Image extends AbstractEntity{

    @Column(name="url", nullable = false)
    private String url;
    @Column(name="principal")
    private boolean principal;
    @ManyToOne
    @JoinColumn(name= "product_id", nullable = false)
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

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return "Image{" +
                "url='" + url + '\'' +
                ", principal=" + principal +
                '}';
    }
}

