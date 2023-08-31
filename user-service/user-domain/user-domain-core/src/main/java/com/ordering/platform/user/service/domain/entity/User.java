package com.ordering.platform.user.service.domain.entity;

import com.ordering.platform.domain.entity.BaseEntity;

import java.util.UUID;

public class User extends BaseEntity {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;

    public User(UUID id, String firstName, String lastName, String email, String address) {
        super.setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public User(String firstName, String lastName, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
