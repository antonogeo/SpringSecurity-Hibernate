package com.antogeo.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "role")
public class Role {

    private int roleId;
    private String name;
    private Set<User> users = new HashSet<User>(0);

    public Role() {
    }


    @Id
    @GeneratedValue
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
