package com.antogeo.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="object")
public class Object {

    private long objectId;
    private String name;
    private int value;
    private User creator;

    public Object() {}

    public Object(String name,
                  int value,
                  User creator) {
        this.name = name;
        this.value = value;
        this.creator = creator;
    }

    @Id
    @GeneratedValue
    @Column(name="object_id")
    public long getObjectId() {
        return objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="value")
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id")
    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }


}
