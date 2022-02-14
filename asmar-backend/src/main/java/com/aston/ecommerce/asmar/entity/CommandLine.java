package com.aston.ecommerce.asmar.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "command_line")
public class CommandLine extends AbstractEntity{

    @Column(name="quantity", nullable = false)
    private int quantity;
    @Column(name="price", nullable = false)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "created_date")
    private Timestamp createdDate;


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

    public BigDecimal getPrice() { return price;}

    public void setPrice(BigDecimal price) {
        this.price = price;  }


    public Timestamp getCreatedDate() { return createdDate;    }

    public void setCreatedDate(Timestamp createdDate) {        this.createdDate = createdDate;    }

    @Override
    public String toString() {
        return "CommandLine{" +
                "quantity=" + quantity +
                ", price=" + price +
                ", product=" + product +
                ", order=" + order +
                ", user=" + user +
                ", createdDate=" + createdDate +
                '}';
    }
}
