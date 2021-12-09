package com.aston.ecommerce.asmar.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity{


    @Column(name="delivery_statut")
    @NotNull
    @NotEmpty
    private String deliveryStatut;

    @Column(name="order_date")
    @NotNull
    @NotEmpty
    private LocalDate orderDate;

    @Column(name="shipping_date")
    @NotNull
    @NotEmpty
    private LocalDate shippingDate;

    @Column(name="delivery_price")
    @NotNull
    @NotEmpty
    private Long deliveryPrice;

    @Column(name="total")
    @NotNull
    @NotEmpty
    private String total;
    @OneToMany
    private List<CommandLine> commandLineList;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
