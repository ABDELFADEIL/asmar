package com.aston.ecommerce.asmar.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Role extends AbstractEntity{

    @Column(name="role_name")
    @NotNull
    @NotEmpty
    private String roleName;
}
