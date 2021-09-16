package com.stedHouston.tweeter.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String first_name;
    private String last_name;
    private Date created_at;
    private String email;
    private String handle;
    private String password;

    public User() {
    }

    public User(Long id, String first_name, String last_name, Date created_at, String email, String handle, String password) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.created_at = created_at;
        this.email = email;
        this.handle = handle;
        this.password = password;
    }

    public User(String first_name, String last_name, Date created_at, String email, String handle, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.created_at = created_at;
        this.email = email;
        this.handle = handle;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", created_at=" + created_at +
                ", email='" + email + '\'' +
                ", handle='" + handle + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
