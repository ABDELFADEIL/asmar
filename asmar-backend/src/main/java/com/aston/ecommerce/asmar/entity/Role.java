package com.aston.ecommerce.asmar.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "role")
public class Role extends AbstractEntity{

    @Column(name="role_name")
    @NotNull
    @NotEmpty
    private String roleName;

    @OneToOne(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;


    public Role(String roleName, User user) {
        this.roleName = roleName;
        this.user = user;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
