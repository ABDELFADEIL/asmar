package com.aston.ecommerce.asmar.entity;



import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "address")
public class Address extends AbstractEntity{


    @Column(name="street", nullable = false)
    @NotNull
    @NotEmpty
    // 12 rue de Paris
    private String street;

    @Column(name="city", nullable = false)
    @NotNull
    @NotEmpty
    private String city;

    @Column(name="state", nullable = false)
    private String state;

    @Column(name="postal_code", nullable = false)
    private String postalCode;

    @Column(name="country", nullable = false)
    private String country;

    @Column(name="add_infos")
    private String addInfos;
    @Column(name="active")
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", addInfos='" + addInfos + '\'' +
                ", active=" + active +
                ", user=" + user +
                '}';
    }
}
