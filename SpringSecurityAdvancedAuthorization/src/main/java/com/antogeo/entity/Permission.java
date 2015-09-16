package com.antogeo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "permission")
public class Permission {

    private long permissionId;
    private String  name;
    private Set<Role> roles = new HashSet<Role>(0);

    public Permission() {
    }

    @Id
    @GeneratedValue
    @Column(name = "permission_id")
    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "role_permission",
            joinColumns = {@JoinColumn(name = "permission_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
