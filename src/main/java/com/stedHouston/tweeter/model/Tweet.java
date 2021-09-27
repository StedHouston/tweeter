package com.stedHouston.tweeter.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private User user;
    private String message;
    private Boolean retweet;
    private Long retweet_author_id;
    private LocalDate created_at;

    public Tweet() {
    }

    public Tweet(User user, String message, Boolean retweet, Long retweet_author_id, LocalDate created_at) {
        this.user = user;
        this.message = message;
        this.retweet = retweet;
        this.retweet_author_id = retweet_author_id;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getRetweet() {
        return retweet;
    }

    public void setRetweet(Boolean retweet) {
        this.retweet = retweet;
    }

    public Long getRetweet_author_id() {
        return retweet_author_id;
    }

    public void setRetweet_author_id(Long retweet_author_id) {
        this.retweet_author_id = retweet_author_id;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at() {
        this.created_at = LocalDate.now();;
    }
}
