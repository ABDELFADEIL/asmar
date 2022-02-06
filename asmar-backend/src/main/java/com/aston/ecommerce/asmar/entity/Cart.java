package com.aston.ecommerce.asmar.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart extends AbstractEntity{


    @OneToOne(targetEntity = User.class)
    @JoinColumn(nullable = false, name = "user_id")
    @JsonIgnore
    private User user;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cart")
    private List<CommandLine> commandLines;

    @Column(name="cartStatus", nullable = false)
    private boolean cartStatus;

    @Column(name="charge", nullable = false)
    private String charge;

    @Column(name="totalPrice", nullable = false)
    private String totalPrice;

    @Column(name="createdDate", nullable = false)
    private Date createdDate;

    public Cart(Long id, User user, boolean cartStatus, String charge, String totalPrice, Date createdDate) {
        super();
    }

    public boolean isCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(boolean cartStatus) {
        this.cartStatus = cartStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public User getUser() { return user;}

    public void setUser(User user) { this.user = user; }

    public List<CommandLine> getCommandLines() { return commandLines;}

    public void setCommandLines(List<CommandLine> commandLines) { this.commandLines = commandLines;}

    @Override
    public String toString() {
        return "Cart{" +
                "user=" + user +
                ", commandLines=" + commandLines +
                ", cartStatus=" + cartStatus +
                ", charge='" + charge + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
