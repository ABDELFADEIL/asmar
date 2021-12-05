package com.aston.ecommerce.asmar.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "address")
public class Address extends AbstractEntity{


    @Column(name="street")
    @NotNull
    @NotEmpty
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


    public Address(String street, String city, String state, String postalCode, String country, String addInfos) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.addInfos = addInfos;
    }

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
}
