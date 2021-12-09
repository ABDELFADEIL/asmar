package com.aston.ecommerce.asmar.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @NotEmpty
    private String password;

    @Column(name="user_name")
    @NotNull
    @NotEmpty
    private String userName;

    @Column(name="registration_date")
    @NotNull
    @NotEmpty
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime registrationDate;

    @Column(name="connection_status")
    @NotNull
    @NotEmpty
    private String connectionStatus;

    @ManyToMany
    private List<Role> roles;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }





    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", registrationDate=" + registrationDate +
                ", connectionStatus='" + connectionStatus + '\'' +
                '}';
    }
}
