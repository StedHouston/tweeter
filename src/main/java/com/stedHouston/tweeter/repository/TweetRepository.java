package com.stedHouston.tweeter.repository;

import com.stedHouston.tweeter.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}
