package com.aston.ecommerce.asmar.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "user")
public class User extends AbstractEntity {


    @Column(name="first_name")
    @NotNull
    @NotEmpty
    private String firstName;

    @Column(name="last_name")
    @NotNull
    @NotEmpty
    private String lastName;

    @Column(name="email")
    @NotNull
    @NotEmpty
    private String email;

    @Column(name="password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotEmpty
    private String password;

    @Column(name="user_name")
    @NotNull
    @NotEmpty
    private String userName;

    @Column(name="registration_date")
    @NotNull
    @NotEmpty
    private Date registrationDate;

    @Column(name="connection_status")
    @NotNull
    @NotEmpty
    private String connectionStatus;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "invoice_address")
    private Address invoiceAddress;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "delivery_address")
    private Address deliveryAddress;


    public User(String firstName, String lastName, String email, String password, String userName, Date registrationDate,
            String connectionStatus, Role role, Address invoiceAddress, Address deliveryAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.registrationDate = registrationDate;
        this.connectionStatus = connectionStatus;
        this.role = role;
        this.invoiceAddress = invoiceAddress;
        this.deliveryAddress = deliveryAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Address getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(Address invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
