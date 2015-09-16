package com.antogeo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "User")
public class User {

    private long userId;
    private String username;
    private String password;
    private Role role;
    private Set<Object> objectCreated = new HashSet<>();


    public User() {
    }

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "creator")
    public Set<Object> getObjectCreated() {
        return objectCreated;
    }

    public void setObjectCreated(Set<Object> objectCreated) {
        this.objectCreated = objectCreated;
    }

}