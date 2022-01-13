package com.aston.ecommerce.asmar.dto;



import com.aston.ecommerce.asmar.entity.AbstractEntity;
import com.aston.ecommerce.asmar.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddressDTO {

    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String addInfos;
    private boolean active;
    private UserDTO userDTO;

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", addInfos='" + addInfos + '\'' +
                ", active=" + active +
                ", userDTO=" + userDTO +
                '}';
    }
}
