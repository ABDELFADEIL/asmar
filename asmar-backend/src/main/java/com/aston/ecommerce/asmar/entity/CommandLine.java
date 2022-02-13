package com.aston.ecommerce.asmar.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Entity
@Table(name = "command_line")
public class CommandLine extends AbstractEntity{

    @Column(name="quantity", nullable = false)
    private int quantity;

    @Column(name="price", nullable = false)
    @NotEmpty
    private float price;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="subTotal", nullable = false)
    @NotEmpty
    private BigDecimal subTotal;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() { return user;}

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {  return quantity;}

    public void setQuantity(int quantity) { this.quantity = quantity;}

    public BigDecimal getSubTotal(BigDecimal multiply) { return subTotal; }

    public void setSubTotal(BigDecimal subTotal) { this.subTotal = subTotal;}


    public float getPrice() { return price;}

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CommandLine{" +
                "quantity=" + quantity +
                ", price=" + price +
                ", product=" + product +
                ", order=" + order +
                ", user=" + user +
                '}';
    }


}
