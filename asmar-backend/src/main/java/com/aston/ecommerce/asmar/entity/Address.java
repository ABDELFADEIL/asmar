package com.aston.ecommerce.asmar.entity;



import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "address")
public class Address extends AbstractEntity{


    @Column(name="street")
    @NotNull
    @NotEmpty
    // 12 rue de Paris
    private String street;

    @Column(name="city")
    @NotNull
    @NotEmpty
    private String city;

    @Column(name="state")
    @NotNull
    @NotEmpty
    private String state;

    @Column(name="postal_Code")
    @NotNull
    @NotEmpty
    private String postalCode;

    @Column(name="country")
    @NotNull
    @NotEmpty
    private String country;

    @Column(name="add_Infos")
    @NotNull
    @NotEmpty
    private String addInfos;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
