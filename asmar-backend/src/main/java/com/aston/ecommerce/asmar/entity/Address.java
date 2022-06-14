package com.aston.ecommerce.asmar.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "address")
public class Address extends AbstractEntity{

    @Column(name="full_name", nullable = false)
    private String fullName;
    @Column(name="street", nullable = false)
    private String street;
    @Column(name="city", nullable = false)
    private String city;
    @Column(name="state", nullable = false)
    private String state;
    @Column(name="postal_code", nullable = false)
    private String postalCode;
    @Column(name="country", nullable = false)
    private String country;
    @Column(name="add_infos", nullable = true)
    private String addInfos;
    @Column(name="delivery")
    private boolean delivery;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private boolean billing;


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddInfos() {
        return addInfos;
    }

    public void setAddInfos(String addInfos) {
        this.addInfos = addInfos;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public boolean isBilling() {
        return billing;
    }

    public void setBilling(boolean billing) {
        this.billing = billing;
    }

    @Override
    public String toString() {
        return "Address{" +
                "fullName='" + fullName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", addInfos='" + addInfos + '\'' +
                ", delivery=" + delivery +
                ", user=" + user +
                ", billing=" + billing +
                '}';
    }
}
